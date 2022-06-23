package com.xiachao.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xiachao
 * @Date: 2022-06-22 19:50
 * @Description: Feign日志配置
 */
@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
