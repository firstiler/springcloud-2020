package com.firstile.controller;

import com.firstile.entities.CommonResult;
import com.firstile.entities.Payment;
import com.firstile.service.PaymentService;
import com.netflix.discovery.DiscoveryClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.runtime.Threads;

@RestController
public class PaymentController {

    Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverProt;

    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        Integer result = service.createPayment(payment);
        CommonResult commonResult = null;
        if(result > 0){
            commonResult = new CommonResult(0, "OK,Port=" + serverProt, payment);
        }else {
            commonResult = new CommonResult(1, "Failed,Port=" + serverProt, null);
        }
        return commonResult;
    }

    @GetMapping("/payment/query/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        Payment payment = service.getPaymentById(id);
        CommonResult commonResult = null;
        if(payment == null){
            commonResult = new CommonResult(1, "Failed,Port=" + serverProt, null);
        }else{
            commonResult = new CommonResult(0, "OK,Port=" + serverProt, payment);
        }
        return commonResult;
    }


    @GetMapping("/payment/print")
    public String printId(){
        return "id=" + 1;
    }

    @GetMapping("/paymet/print")
    public String printId1(){
        return "id=" + 1;
    }

}
