package com.xiachao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderZookeeperController {

    public static final String INVOKE_URL = "http://cloud-provider-payment-zookeeper";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/payment/zk/info")
    public String  getPaymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk/info",String.class);
    }

}
