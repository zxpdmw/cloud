package com.example.springcloud.controller;

import com.example.springcloud.pojo.Payment;
import com.example.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-06 09:39
 **/
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://consul-provider-service";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("consumer/payment/consul")
    public String paymentInfo(){
        return   restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }


}
