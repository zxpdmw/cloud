package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-07 20:04
 **/
@RestController
@Slf4j
public class OrderController {
    public static final String INVOKE_URL="http://cloud-provider-service";

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("consumer/payment/zk")
    public String paymentInfo(){
      return   restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
