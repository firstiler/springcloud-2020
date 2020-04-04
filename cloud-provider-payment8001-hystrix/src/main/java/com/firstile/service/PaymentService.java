package com.firstile.service;

public interface PaymentService {

    String getOk(Integer id);

    String getTimeOut(Integer id);

    String getCircuitBreaker(Integer id) throws Exception;

}
