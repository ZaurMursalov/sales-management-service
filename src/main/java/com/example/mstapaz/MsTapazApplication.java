package com.example.mstapaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsTapazApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTapazApplication.class, args);
    }

}
