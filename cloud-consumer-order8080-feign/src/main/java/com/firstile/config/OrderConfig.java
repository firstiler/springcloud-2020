package com.firstile.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    Logger.Level getFeignLogLevel(){
        return Logger.Level.FULL;
    }

}
