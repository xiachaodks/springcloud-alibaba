package com.xiachao.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author: xiachao
 * @Date: 2022-06-22 20:26
 * @Description:
 */
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    /**
     * 正常访问，一切OK
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O";
    }

    /**
     * 超时访问，演示降级
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_FallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        final Integer TIME_OUT = 5;
        try {
            TimeUnit.SECONDS.sleep(TIME_OUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName()
                + "paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O，耗费" + TIME_OUT + "秒";
    }

    public String paymentInfo_TimeOut_FallbackMethod(Integer id) {
        return "线程池:" + Thread.currentThread().getName()
                + "paymentInfo_TimeOut,id: " + id + "\t" + "服务超时或系统故障，请稍后再试！o(╥﹏╥)o";
    }

    @Override
    @HystrixCommand(defaultFallback = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//配置开启服务熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    //服务熔断
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }

    //服务熔断fallback方法
    public String paymentCircuitBreaker_fallback() {
        return "id 不能负数，请稍后再试 ";
    }

}
