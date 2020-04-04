package com.firstile.service;

import com.firstile.entities.CommonResult;
import com.firstile.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/query/{id}")
    // 此处方法名生产者方法名没关系，与生产者发生映射的只有GET注解
    CommonResult getPaymentBy(@PathVariable("id") Long id);

}
