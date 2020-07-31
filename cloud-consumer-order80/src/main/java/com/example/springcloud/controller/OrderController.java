package com.example.springcloud.controller;

import com.example.springcloud.lb.LoadBalancer;
import com.example.springcloud.pojo.Payment;
import com.example.springcloud.util.CommonResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-06 09:39
 **/
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancer loadBalancer;
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/insert")
    public CommonResult<Payment> insert(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/insert",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Integer id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getForEntity(@PathVariable Integer id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
         if (entity.getStatusCode().is2xxSuccessful()){
             return entity.getBody();
         }else {
             return new CommonResult<>(444,"操作失败");
         }
    }

    @RequestMapping("consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null ||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance=loadBalancer.INSTANCE(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String zipkin(){

        return restTemplate.getForObject("http://localhost:8001/payment/zipkin",String.class);
    }


}
