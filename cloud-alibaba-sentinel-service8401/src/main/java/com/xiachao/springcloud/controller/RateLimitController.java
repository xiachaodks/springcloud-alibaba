package com.xiachao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiachao.springcloud.entities.CommonResult;
import com.xiachao.springcloud.entities.Payment;
import com.xiachao.springcloud.myHandle.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiachao
 * @Date: 2022-07-16 16:05
 * @Description:
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleByResource")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试成功OK",
                new Payment(2022L, "Serial2022"));
    }

    public CommonResult handleByResource(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() +
                "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL限流测试成功OK",
                new Payment(2022L, "Serial2022"));
    }

    /**
     * 自定义通用的限流处理逻辑，
     * blockHandlerClass = CustomerBlockHandler.class
     * blockHandler = handleException
     * 上述配置：找CustomerBlockHandler类里的handleException方法进行兜底处理
     * 自定义通用的限流处理逻辑
     *
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流处理逻辑");
    }
}
