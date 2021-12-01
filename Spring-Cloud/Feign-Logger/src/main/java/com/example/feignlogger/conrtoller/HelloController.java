package com.example.feignlogger.conrtoller;

import com.example.feignlogger.MyFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/1
 **/
@RestController
public class HelloController {
    @Resource
    MyFeignClient myFeignClient;
    @GetMapping("/hello")
    public String index() {
        return myFeignClient.hello();
    }
}
