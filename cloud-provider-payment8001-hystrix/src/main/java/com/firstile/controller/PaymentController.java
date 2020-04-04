package com.firstile.controller;

import com.firstile.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("/payment/ok/{id}")
    public String getOk(@PathVariable("id") Integer id){

        return paymentService.getOk(id);
    }

    @GetMapping("/payment/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id){

        return paymentService.getTimeOut(id);
    }


    @GetMapping("/payment/circuit/{id}")
    public String getCircuitBreaker(@PathVariable("id") Integer id) throws Exception {

        return paymentService.getCircuitBreaker(id);
    }

}
