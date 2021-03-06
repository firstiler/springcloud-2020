package com.firstile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZk8080 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk8080.class, args);
    }

}
