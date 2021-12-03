package com.example.controller;


import com.example.hystrixdashboard.HelloProducer;
import org.springframework.stereotype.Component;

@Component
public class HelloProducerHystrix implements HelloProducer {

    @Override
    public String hello() {
        return "出现错误";
    }
}