package com.iqas.server.controller;

import com.iqas.server.model.DocumentModel;
import com.iqas.server.model.KbModel;
import com.iqas.server.service.DocumentService;
import com.iqas.server.service.KbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KbController {

    @Autowired
    private KbService kbService;

    @Autowired
    private DocumentService documentService;

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

    @RequestMapping(value = "/api/kb/{id}/doc",method = RequestMethod.POST)
    public DocumentModel postDoc(@RequestBody DocumentModel documentModel, @PathVariable("id") Integer id){
        return documentService.addDocument(documentModel, id);
    }
}
