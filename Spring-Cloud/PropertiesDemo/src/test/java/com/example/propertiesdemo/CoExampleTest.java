package com.example.propertiesdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class CoExampleTest {

    @Autowired
    private CoExample coExample;
    @Test
    void getName() {
    System.out.println(coExample.getName());
    }

    @Test
    void getAge() {
    System.out.println(coExample.getAge());
    }

    @Test
    void getAddresses() {
    System.out.println(coExample.getAddress());
    }
}