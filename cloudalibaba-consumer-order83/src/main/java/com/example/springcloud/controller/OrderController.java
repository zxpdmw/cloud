package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 16:47
 **/
@RestController
@Slf4j
public class OrderController {
    @Resource
    RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getServerURL(@PathVariable Integer id){
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);

    }
}
