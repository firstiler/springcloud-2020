package com.firstile.service;

import com.firstile.service.fallback.PaymentServiceFallback;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/ok/{id}")
    String getOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    String getTimeout(@PathVariable("id") Integer id);

}
