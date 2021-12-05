package com.example.gatewayfilter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: NotFoundController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/12/5
 **/
@RestController
public class NotFoundController {
    @RequestMapping("/notfound")
    public Mono<Map<String, String>> notFound() {
    HashMap<String, String> stringMap = new HashMap<>(16);
    stringMap.put("code","404");
    stringMap.put("data","Not Found");
    return Mono.just(stringMap);
    }
    @RequestMapping(value = "/fallback")
    public Mono<Map<String, String>> fallback() {
        HashMap<String, String> stringMap = new HashMap<>(16);
        stringMap.put("code","100");
        stringMap.put("data","Service Not Available");
        return Mono.just(stringMap);
    }
}
