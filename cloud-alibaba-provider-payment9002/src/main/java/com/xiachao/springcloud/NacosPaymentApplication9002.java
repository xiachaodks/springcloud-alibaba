package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: xiachao
 * @Date: 2022-07-04 12:06
 * @Description:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentApplication9002.class,args);
    }
}
