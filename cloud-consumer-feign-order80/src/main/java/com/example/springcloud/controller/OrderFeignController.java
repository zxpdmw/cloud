package com.example.springcloud.controller;

import com.example.springcloud.pojo.Payment;
import com.example.springcloud.service.PaymentFeignService;
import com.example.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 09:21
 **/
@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id){
        return paymentFeignService.get(id);
    }

    @GetMapping("consumer/payment/feign/timeout")
    public String getSleep(){
        return paymentFeignService.getSleep();
    }
}
