package com.example.ribbon_rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuyCui
 */
@SpringBootApplication
public class RibbonRuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonRuleApplication.class, args);
    }

  /**
   * 开启客户端负载均衡
   * 实例化 RestTemplate
   */
  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
