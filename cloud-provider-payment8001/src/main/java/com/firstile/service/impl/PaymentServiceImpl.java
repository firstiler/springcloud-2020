package com.firstile.service.impl;

import com.firstile.dao.PaymentDao;
import com.firstile.entities.Payment;
import com.firstile.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao dao;

    @Override
    public Integer createPayment(Payment payment) {

        return dao.createPayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return dao.getPaymentById(id);
    }
}
