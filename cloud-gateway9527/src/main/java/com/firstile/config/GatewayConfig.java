package com.firstile.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routers = builder.routes();

        routers.route("path_route-firstile",
                r -> r.path("/print").uri("http://localhost:8001/payment/print")).build();
        return routers.build();
    }


}
