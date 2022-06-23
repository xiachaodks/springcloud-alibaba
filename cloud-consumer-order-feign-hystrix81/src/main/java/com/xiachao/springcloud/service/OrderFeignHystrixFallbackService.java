package com.xiachao.springcloud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiachao
 * @Date: 2022-06-23 12:32
 * @Description: 对OrderFeignHystrixService中的业务做统一降级处理
 */
@Service
public class OrderFeignHystrixFallbackService implements OrderFeignHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-order-feign-hystrix81的方法paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-order-feign-hystrix81的方法paymentInfo_TimeOut";
    }
}
