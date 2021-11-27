package com.example.consulprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: HelloController
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/27
 **/
@RestController
public class HelloController {
  /** 注入“服务提供者”的名称 */
  @Value("${provider.name}")
  private String name;

  /** 注入服务提供者的端口号 */
  @Value("${server.port}")
  private String port;

    @Override
    public String toString() {
        return "HelloController{" +
                "name='" + name + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

    /**
     * 提供的接口，用于返回信息
     */
@RequestMapping("/hello")
    public String hello() {
        return toString();
    }
}
