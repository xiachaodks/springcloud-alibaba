package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentOpenFeignApplication8008 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentOpenFeignApplication8008.class,args);
    }
}
