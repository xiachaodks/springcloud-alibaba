package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOrderConsulApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderConsulApplication81.class,args);
    }
}
