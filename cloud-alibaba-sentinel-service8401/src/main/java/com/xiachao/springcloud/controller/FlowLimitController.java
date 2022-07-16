package com.xiachao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiachao
 * @Date: 2022-07-16 14:12
 * @Description:
 */
@RestController
@Slf4j
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testC 测试RT");
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        int age = 10 / 0;
        log.info("testD 测试异常比例");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        int age = 10 / 0;
        log.info("testE 测试异常数");
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandle_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "-----testHotKey";
    }

    public String dealHandle_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandle_testHotKey,o(╥﹏╥)o";
    }
}
