package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xiachao
 * @Date: 2022-06-22 21:28
 * @Description:
 */

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerOrderFeignHystrixApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignHystrixApplication81.class,args);
    }
}
