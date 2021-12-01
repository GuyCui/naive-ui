package com.example.consumerribbonnodiscovery.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/30
 */
@RestController
public class HelloController {
  @Resource private RestTemplate restTemplate;

  @GetMapping("/hello")
  public String hello() {
    return restTemplate.getForObject("http://provider/" + "hello", String.class);
  }
}
