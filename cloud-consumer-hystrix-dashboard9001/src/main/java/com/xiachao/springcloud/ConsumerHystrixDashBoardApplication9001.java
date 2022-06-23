package com.xiachao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author: xiachao
 * @Date: 2022-06-23 17:10
 * @Description:
 */
@SpringBootApplication
@EnableHystrixDashboard
public class    ConsumerHystrixDashBoardApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHystrixDashBoardApplication9001.class,args);
    }
}
