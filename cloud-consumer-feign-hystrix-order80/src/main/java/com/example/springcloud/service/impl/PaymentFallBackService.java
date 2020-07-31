package com.example.springcloud.service.impl;

import org.springframework.stereotype.Component;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 14:36
 **/
@Component
public class PaymentFallBackService implements com.example.springcloud.service.PaymentHystrixService {
    @Override
    public String ok(Integer id) {
        return "payment-fallback+ok";
    }

    @Override
    public String error(Integer id) {
        return "payment-fallback+ok";
    }
}
