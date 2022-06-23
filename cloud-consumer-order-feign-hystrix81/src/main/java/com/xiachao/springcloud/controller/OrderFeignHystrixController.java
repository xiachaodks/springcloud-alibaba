package com.xiachao.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiachao.springcloud.service.OrderFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiachao
 * @Date: 2022-06-22 21:32
 * @Description:
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutDefaultFallback")
public class OrderFeignHystrixController {

    @Autowired
    private OrderFeignHystrixService orderFeignHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = orderFeignHystrixService.paymentInfo_OK(id);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int num =10/0;
        String result = orderFeignHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    //defaultFallback方法
    public String paymentInfo_TimeOutDefaultFallback() {
        return "我是defaultFallback方法，请稍后再试，/(ㄒoㄒ)/~";
    }

}
