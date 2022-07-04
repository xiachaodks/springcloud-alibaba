package com.xiachao.springcloud.controller;

import com.xiachao.springcloud.service.IMessageProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: xiachao
 * @Date: 2022-07-03 17:03
 * @Description:
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProviderService messageProviderService;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProviderService.send();
    }
}
