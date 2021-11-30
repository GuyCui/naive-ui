package com.example.consumerribbonnodiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerRibbonNoDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRibbonNoDiscoveryApplication.class, args);
    }

    /**
     * 开启负载均衡
     * 实例化 RestTemplate
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
