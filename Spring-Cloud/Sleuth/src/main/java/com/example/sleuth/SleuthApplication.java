package com.example.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SleuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(SleuthApplication.class, args);
  }

  private static Logger logger = LoggerFactory.getLogger(SleuthApplication.class);

  @RequestMapping("/hello")
  public String home() {
    logger.info("处理请求" + "/home");
    return "home";
  }
}
