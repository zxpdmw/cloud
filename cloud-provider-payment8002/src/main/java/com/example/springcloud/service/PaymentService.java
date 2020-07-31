package com.example.springcloud.service;


import com.example.springcloud.pojo.Payment;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-06 08:48
 **/
public interface PaymentService {

    Payment getById(Integer id);


    int insertPayment(Payment payment);
}
