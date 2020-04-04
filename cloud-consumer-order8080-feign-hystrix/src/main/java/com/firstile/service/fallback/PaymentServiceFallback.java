package com.firstile.service.fallback;

import com.firstile.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceFallback implements PaymentService {

    private final String errorInfo = "爸爸对不起，系统炸了";

    @Override
    public String getOk(Integer id) {
        return errorInfo;
    }

    @Override
    public String getTimeout(Integer id) {
        return errorInfo;
    }
}
