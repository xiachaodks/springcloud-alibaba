package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: xiachao
 * @Date: 2022-07-01 20:57
 * @Description: Gateway主启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication9527.class,args);
    }

}
