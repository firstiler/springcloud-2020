package com.firstile.controller;


import com.firstile.entities.CommonResult;
import com.firstile.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private String PAYMENT_UIL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult createPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_UIL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/query/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_UIL + "/payment/query/" + id, CommonResult.class);
    }



}
