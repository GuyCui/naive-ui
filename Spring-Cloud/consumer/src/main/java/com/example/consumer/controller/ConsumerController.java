package com.example.consumer.controller;

import com.example.consumer.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: ConsumerController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/21
 **/
@RestController
public class ConsumerController {
    /**
     * 注入接口
     */
    @Autowired
    MyFeignClient myFeignClient;
    @RequestMapping("/hello")
    public String index(){
        return myFeignClient.hello();
    }
}
