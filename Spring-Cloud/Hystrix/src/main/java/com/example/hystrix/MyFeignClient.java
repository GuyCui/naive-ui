package com.example.hystrix;

import com.example.hystrix.controller.HelloHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;

@Primary
@FeignClient(name = "service-provider", fallback = HelloHystrix.class)
public interface MyFeignClient {
    @RequestMapping(value = "/hello")
    String hello();
}
