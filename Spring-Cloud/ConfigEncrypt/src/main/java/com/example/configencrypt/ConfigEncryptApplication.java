package com.example.configencrypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigEncryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEncryptApplication.class, args);
    }

}
