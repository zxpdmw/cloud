package com.example.springcloud.service.impl;

import com.example.springcloud.pojo.Payment;
import com.example.springcloud.service.PaymentService;
import com.example.springcloud.util.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 10:57
 **/
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Integer id) {
        return new CommonResult<>(444,"服务降级返回",new Payment(id,"errorcode"));
    }
}
