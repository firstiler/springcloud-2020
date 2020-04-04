package com.firstile.controller;

import com.firstile.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String getOk(@PathVariable("id") Integer id){
        return paymentService.getOk(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id){
        return paymentService.getTimeout(id);
    }


}
