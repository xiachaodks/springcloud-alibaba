package com.xiachao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiachao
 * @Date: 2022-07-04 12:14
 * @Description:
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/get/{id}")
    public String getPaymentInfo(@PathVariable("id") Integer id){
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }
}
