package com.xiachao.springcloud.service.impl;

import com.xiachao.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: xiachao
 * @Date: 2022-07-03 16:55
 * @Description:
 */
@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderServiceImpl implements IMessageProviderService {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private MessageChannel output;// 消息的发送管道

    //发送消息
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());//创建并发送消息
        System.out.println("***serial: " + serial + "\tserverPort: " + serverPort);
        return null;
    }
}
