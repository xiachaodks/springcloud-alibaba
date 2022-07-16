package com.xiachao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiachao
 * @Date: 2022-07-04 13:13
 * @Description:
 */
@RestController
@Slf4j
@RefreshScope //在控制器类加入@RefreshScope注解使当前类下的配置支持Nacos的动态刷新功能
@RequestMapping("/nacos")
public class NacosConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info   ")
    public String getConfigInfo() {
        return configInfo;
    }
}
