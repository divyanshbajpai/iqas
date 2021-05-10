package com.iqas.server.service;

import com.iqas.server.model.CustomSequences;
import com.iqas.server.model.KbModel;
import com.iqas.server.repository.KbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KbService {

    @Autowired
    private KbRepository kbRepository;

    @Autowired
    private NextSequenceService nextSequenceService;

    public List<KbModel> getAllKb() {
        return kbRepository.findAll();
    }

    public KbModel addKb(KbModel kbModel) {
        kbModel.setKbId(nextSequenceService.getNextSequence("customSequencesKb"));
        return kbRepository.save(kbModel);
    }

    public KbModel findOneKb(Integer kbId){
        KbModel retModel= kbRepository.findBykbId(kbId);
        return retModel;
    }

    public KbModel putKb(KbModel kbModel){
        return kbRepository.save(kbModel);
    }
}


