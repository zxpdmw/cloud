package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 08:35
 **/
public interface LoadBalancer {
    ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances);
}
