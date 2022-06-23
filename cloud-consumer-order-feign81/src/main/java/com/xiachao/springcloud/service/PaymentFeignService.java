package com.xiachao.springcloud.service;

import com.xiachao.springcloud.entities.CommonResult;
import com.xiachao.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: xiachao
 * @Date: 2022-06-22 18:36
 * @Description:
 */
@Service
@FeignClient("CLOUD-PAYMENT-FEIGN-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
