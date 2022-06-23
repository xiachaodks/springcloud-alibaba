package com.xiachao.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xiachao
 * @Date: 2022-06-22 15:26
 * @Description: 自定义Ribbon规则
 */

@Configuration
public class MyselfRandomRuler {

    @Bean
    public IRule RandomRule(){
        //定义为随机
        return new RandomRule();
    }
}
