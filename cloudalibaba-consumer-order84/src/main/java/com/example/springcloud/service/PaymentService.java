package com.example.springcloud.service;

import com.example.springcloud.pojo.Payment;
import com.example.springcloud.service.impl.PaymentServiceImpl;
import com.example.springcloud.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 10:55
 **/
@FeignClient(value = "nacos-provider-payment",fallback = PaymentServiceImpl.class)
public interface PaymentService {

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Integer id);
}
