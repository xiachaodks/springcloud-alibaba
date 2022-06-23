package com.xiachao.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: xiachao
 * @Date: 2022-06-22 20:25
 * @Description:
 */
@Service
public interface PaymentHystrixService {

    //正常访问，一切OK
    public String paymentInfo_OK(Integer id);

    //超时访问，演示降级
    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
