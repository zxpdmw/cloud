package com.example.springcloud.service;

import com.example.springcloud.service.impl.PaymentFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 11:01
 **/
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFallBackService.class)
@Service
public interface PaymentHystrixService {
    @GetMapping("payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/error/{id}")
    public String error(@PathVariable("id") Integer id);
}
