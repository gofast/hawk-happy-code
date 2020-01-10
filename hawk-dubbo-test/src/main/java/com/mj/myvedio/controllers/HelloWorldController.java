package com.mj.myvedio.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(value = "/helloWorld", method=RequestMethod.GET)
    public String helloWorld(String hello){
        return "SUCCESS : " + hello;
    }
}
