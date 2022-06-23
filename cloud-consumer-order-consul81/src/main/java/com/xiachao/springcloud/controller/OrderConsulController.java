package com.xiachao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://cloud-provider-payment-consul";

    @GetMapping("/payment/consul/info")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul/info",String.class);
    }

}
