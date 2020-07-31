package com.example.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-07 20:24
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("payment/consul")
    public String consul(){
        return "springcloud with consul"+serverPort+"\t"+ UUID.randomUUID().toString().substring(5);
    }
}
