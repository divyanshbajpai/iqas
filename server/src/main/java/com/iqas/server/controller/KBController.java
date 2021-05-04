package com.iqas.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KBController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
