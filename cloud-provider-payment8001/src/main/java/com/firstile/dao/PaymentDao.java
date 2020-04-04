package com.firstile.dao;

import com.firstile.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentDao {

    public Integer createPayment(Payment payment);

    public Payment getPaymentById(Long id);

}
