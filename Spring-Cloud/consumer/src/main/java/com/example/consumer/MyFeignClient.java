package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: MyFeignClient
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/21
 */
@FeignClient(name = "Provider")
public interface MyFeignClient {
    @RequestMapping(value = "/hello")
    String hello();
}
