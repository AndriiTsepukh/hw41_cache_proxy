package com.example.hw41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableCaching
public class Hw41Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw41Application.class, args);
    }

}
