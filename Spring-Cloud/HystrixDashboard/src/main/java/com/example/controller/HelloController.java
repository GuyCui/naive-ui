package com.example.controller;


import com.example.hystrixdashboard.HelloProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    HelloProducer helloProducer;

    @RequestMapping("/hello")
    public String index() {
        return helloProducer.hello();
    }

}