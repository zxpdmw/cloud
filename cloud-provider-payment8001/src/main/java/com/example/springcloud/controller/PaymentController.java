package com.example.springcloud.controller;

import com.example.springcloud.pojo.Payment;
import com.example.springcloud.service.PaymentService;
import com.example.springcloud.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-06 08:49
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment/insert")
    public CommonResult insert(@RequestBody Payment payment){
        int result = paymentService.insertPayment(payment);
        log.info("操作结果"+result);
        if (result==1){
            return new CommonResult(200,"操作成功", result);
        }else {
            return new CommonResult(500,"操作失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Integer id){
        Payment result = paymentService.getById(id);
        log.info("操作结果"+result);
        if (result!=null){
            return new CommonResult(200,"查询操作成功",result);
        }else {
            return new CommonResult(500,"查询操作失败",null);
        }
    }

    @GetMapping("payment/lb")
    public String getLB(){
        return port;
    }

    @GetMapping("payment/feign/timeout")
    public String getSleep(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("/payment/zipkin")
    public String zipkin(){
        return "欢迎来到zipkin++++++++++++++++++++++++++++";
    }
}
