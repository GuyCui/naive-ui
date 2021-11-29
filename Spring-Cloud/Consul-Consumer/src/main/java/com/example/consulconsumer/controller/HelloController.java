package com.example.consulconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/27
 */
@RestController
public class HelloController {
  @Resource private LoadBalancerClient loadBalancerClient;

  @GetMapping("/hello")
  public String hello() {
    ServiceInstance choose = loadBalancerClient.choose("service-provider");
    URI uri = choose.getUri();
    String forObject = new RestTemplate().getForObject(uri + "/hello", String.class);
    System.out.println(forObject);
    return forObject;
  }
}