package com.example.hystrix.controller;

import com.example.hystrix.MyFeignClient;
import org.springframework.stereotype.Component;

/**
 * @program: Hystrix
 * @description: 回调
 * @author: 崔明志
 * @create: 2021-12-03 11:08
 */
@Component
public class HelloHystrix implements MyFeignClient {

    @Override
    public String hello() {
        return "出现错误，请稍后再试";
    }
}