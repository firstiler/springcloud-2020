package com.firstile.service;

import com.firstile.entities.Payment;

public interface PaymentService {

    public Integer createPayment(Payment payment);

    public Payment getPaymentById(Long id);

}