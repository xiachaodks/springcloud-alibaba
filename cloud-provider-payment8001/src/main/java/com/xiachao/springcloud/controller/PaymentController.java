package com.xiachao.springcloud.controller;

import com.xiachao.springcloud.entities.CommonResult;
import com.xiachao.springcloud.entities.Payment;
import com.xiachao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult createPayment(Payment payment) {
        int result = paymentService.createPayment(payment);
        log.info("*****插入操作返回结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败,serverPort: " + serverPort, null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> ById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}", payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort: " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询Id: "
                    + id + "serverPort: " + serverPort, null);
        }
    }

    @GetMapping(value = "/discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******service" + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t"
                    + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }

    //增加方法测试负载均衡
    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return this.serverPort;
    }


    // ====================> zipkin+sleuth
    @GetMapping("/zipkin")
    public String paymentZipkin(){
        return "hi ,i'am paymentzipkin server fall back，welcome，O(∩_∩)O哈哈~";
    }
}
