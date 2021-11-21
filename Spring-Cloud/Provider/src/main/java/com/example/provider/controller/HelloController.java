package com.example.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/21
 **/
@RestController
public class HelloController {
  /** 注入服务提供者名称 */
  @Value("${Provider.name}")
  private String name;

    /**
     * 注入服务提供者端口号
     */
    @Value("${server.port}")
    private String port;

    /**
     * 提供的接口，用于返回信息
     */
    @RequestMapping("/hello")
    public String hello(){
        String srt = "provider: " + name + " port: " + port;
        // 返回数据
        return srt;
    }
}
