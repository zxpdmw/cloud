package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 16:23
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @GetMapping("payment/nacos/{id}")
    public String getPortNacos(@PathVariable Integer id){
        return "nacos register, serverport"+port+"\t"+id;
    }

}
