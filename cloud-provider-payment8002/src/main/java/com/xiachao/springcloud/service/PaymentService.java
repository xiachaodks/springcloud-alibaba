package com.xiachao.springcloud.service;

import com.xiachao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int createPayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
