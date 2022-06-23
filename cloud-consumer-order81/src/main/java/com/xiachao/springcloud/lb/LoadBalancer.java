package com.xiachao.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    ServiceInstance getInstances(List<ServiceInstance> serviceInstances);
}
