package com.example.springcloud.controller;

import com.example.springcloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 11:48
 **/
@RestController
public class MessageProviderController {
    @Autowired
    MessageProvider messageProvider;

    @GetMapping("sendMessage")
    public String get(){
       return messageProvider.send();
    }
}
