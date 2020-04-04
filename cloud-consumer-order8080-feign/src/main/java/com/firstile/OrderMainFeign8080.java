package com.firstile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderMainFeign8080 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign8080.class, args);
    }

}
