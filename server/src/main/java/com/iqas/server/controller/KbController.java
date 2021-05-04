package com.iqas.server.controller;

import com.iqas.server.model.KbModel;
import com.iqas.server.service.KbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KbController {

    @Autowired
    private KbService kbService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/api/kb",method = RequestMethod.GET)
    public List<KbModel> getAllKb(){
        return kbService.getAllKb();
    }

    @RequestMapping(value = "/api/kb",method = RequestMethod.POST)
    public KbModel postKb(@RequestBody KbModel kbModel){
        return kbService.addKb(kbModel);
    }
}
