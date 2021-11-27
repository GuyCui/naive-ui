package com.example.propertiesdemo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @className: CoExample
 * @description: TODO 类描述
 * @author: GuyCui
 * @date: 2021/11/23
 **/
@Data
@Component
@ConfigurationProperties(prefix = "com.example")
public class CoExample {
    private String name;
    private int age;
    private List<String> address;
}
