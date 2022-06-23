package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: xiachao
 * @Date: 2022-06-22 18:35
 * @Description:
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerOrderFeignApplication81 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderFeignApplication81.class,args);
    }
}
