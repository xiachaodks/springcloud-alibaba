package com.xiachao.springcloud;

import com.xiachao.myrule.MyselfRandomRuler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，使配置生效
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRandomRuler.class)
public class ConsumerOrderApplication81 {
    public static void main(String[] args)  {
        SpringApplication.run(ConsumerOrderApplication81.class,args);
    }
}
