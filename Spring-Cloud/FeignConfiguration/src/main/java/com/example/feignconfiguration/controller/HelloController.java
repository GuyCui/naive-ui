package com.example.feignconfiguration.controller;


import com.example.feignconfiguration.MyFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    MyFeignClient myFeignClient;

    @GetMapping("/hello")
    public String index() {
        return myFeignClient.hello();
    }

}