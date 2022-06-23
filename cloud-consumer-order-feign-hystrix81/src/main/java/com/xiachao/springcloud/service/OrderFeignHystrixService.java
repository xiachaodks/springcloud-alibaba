package com.xiachao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiachao
 * @Date: 2022-06-22 21:30
 * @Description:
 */
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX",
        fallback = OrderFeignHystrixFallbackService.class)//设置服务降级Fallback处理类
@Service
public interface OrderFeignHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
