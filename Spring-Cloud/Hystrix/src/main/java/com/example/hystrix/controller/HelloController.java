package com.example.hystrix.controller;

import com.example.hystrix.MyFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 你好控制器
 *
 * @author GuyCui
 * @date 2021/12/03
 */
@RestController
public class HelloController {
  @Resource MyFeignClient myFeignClient;

  /**
   * 指数
   *
   * @return {@code String}
   */
  @RequestMapping("/hello")
  public String index() {
    return myFeignClient.hello();
  }
}
