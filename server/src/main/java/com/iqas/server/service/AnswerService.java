package com.iqas.server.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnswerService {

    public String fetchAnswer(Integer kbId, Integer docId, String question){
        RestTemplate restTemplate=new RestTemplate();
        //String answer= restTemplate.postForObject("http://localhost/kb/1/doc/1",String.class);
        return  ""; //WIP
    }

}
