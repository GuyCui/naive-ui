package com.example.hystrixdashboard.controller;


import com.example.hystrixdashboard.HelloProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloProducer helloProducer;

    @RequestMapping("/hello")
    public String index() {
        return helloProducer.hello();
    }

}