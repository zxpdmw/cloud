package com.example.springcloud.service;

import com.example.springcloud.pojo.Payment;
import com.example.springcloud.util.CommonResult;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 09:22
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable Integer id);

    @GetMapping("payment/feign/timeout")
    public String getSleep();
}
