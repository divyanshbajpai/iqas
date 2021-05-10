package com.iqas.server.service;


import com.iqas.server.model.DocumentModel;
import com.iqas.server.model.KbModel;
import com.iqas.server.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private NextSequenceService nextSequenceService;

    @Autowired
    private KbService kbService;

    private List<DocumentModel> getAllDocuments() {
        return documentRepository.findAll();
    }

    public DocumentModel addDocument(DocumentModel documentModel, Integer kbId) {

        KbModel retKbModel = kbService.findOneKb(kbId);
        DocumentModel retModel =null;
        if (retKbModel == null) {
            retModel= null;
        } else {
            documentModel.setDocId(nextSequenceService.getNextSequence("customSequencesDoc"));
            DocumentModel savedDocument = documentRepository.save(documentModel);
            List<Integer> docIdListIni = null;
            if (retKbModel.getDocId() == null)
                docIdListIni = new ArrayList<Integer>();
            else {
                docIdListIni = new ArrayList<>(retKbModel.getDocId());
            }
            docIdListIni.add(savedDocument.getDocId());
            retKbModel.setDocId(docIdListIni);
            kbService.putKb(retKbModel);
            retModel= savedDocument;
        }
        return retModel;
    }
}