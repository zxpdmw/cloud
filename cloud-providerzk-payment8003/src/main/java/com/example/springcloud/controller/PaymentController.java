package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.UUID;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-07 19:43
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("payment/zk")
    public String zk(){
        return "springcloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString().substring(5);
    }
}
