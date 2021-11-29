package com.example.ribbon_rule.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className: TestController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/29
 */
@RestController
public class TestController {
  @Resource private LoadBalancerClient loadBalancerClient;
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");

  @GetMapping("/test")
  public void test() {
    ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
    System.out.println(
        serviceInstance.getHost()+ " " + serviceInstance.getPort() + " " + sdf.format(date));
  }
}
