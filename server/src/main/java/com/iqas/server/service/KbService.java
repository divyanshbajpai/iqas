package com.iqas.server.service;

import com.iqas.server.model.KbModel;
import com.iqas.server.repository.KbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KbService {

    @Autowired
    private KbRepository kbRepository;

    public List<KbModel> getAllKb() {
        return kbRepository.findAll();
    }

    public KbModel addKb(KbModel kbModel){
        return kbRepository.save(kbModel);
    }
}


