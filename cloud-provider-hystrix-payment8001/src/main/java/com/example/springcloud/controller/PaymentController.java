package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import com.netflix.discovery.converters.Auto;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 10:32
 **/
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    private String post;

    @GetMapping("payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        String s = paymentService.paymentInfo(id);
        log.info(s);
        return s;
    }

    @GetMapping("payment/hystrix/error/{id}")
    public String error(@PathVariable("id") Integer id) throws InterruptedException {
        String s = paymentService.paymentError(id);
        log.info(s);
        return s;
    }

    @GetMapping("payment/hystrix/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id) {
        String s = paymentService.circuitBreakerTest(id);
        log.info(s);
        return s;
    }
}
