package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrderApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderApplication81.class,args);
    }
}
