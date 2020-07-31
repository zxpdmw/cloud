package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 11:01
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class OrderHystrixController {
    @Autowired
    PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return paymentHystrixService.ok(id);
    }

//    @HystrixCommand(fallbackMethod = "fallbackHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/error/{id}")
    public String error(@PathVariable("id") Integer id){

        return paymentHystrixService.error(id);
    }

    public String fallbackHandler(Integer id){
        return "系统繁忙,请稍后再试";
    }
    public String payment_Global_FallBackMethod(){
        return "全局系统繁忙,请稍后再试";
    }


}
