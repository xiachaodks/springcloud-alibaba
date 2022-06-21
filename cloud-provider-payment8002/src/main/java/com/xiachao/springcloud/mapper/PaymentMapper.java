package com.xiachao.springcloud.mapper;

import com.xiachao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    public Integer createPayment(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
