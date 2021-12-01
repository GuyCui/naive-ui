package com.example.feignlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class FeignLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignLoggerApplication.class, args);
    }

}
