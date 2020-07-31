package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 17:20
 **/
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String config;
    @GetMapping("config/info")
    public String getConfig(){
        return config;
    }

}
