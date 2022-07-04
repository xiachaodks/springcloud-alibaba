package com.xiachao.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiachao
 * @Date: 2022-07-02 11:53
 * @Description:
 */
@RestController
@RefreshScope //刷新
@RequestMapping("/config")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;


    @RequestMapping("/info")
    public String getConfigInfo(){
        return configInfo;
    }

}
