package com.example.springcloud.service.impl;



import com.example.springcloud.mapper.PaymentMapper;
import com.example.springcloud.pojo.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-06 08:51
 **/
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentMapper paymentMapper;
    @Override
    public Payment getById(Integer id) {
        return paymentMapper.getById(id);
    }

    @Override
    public int insertPayment(Payment payment) {
        return paymentMapper.insertPayment(payment);
    }
}
