package com.example.springcloud.service;



import com.example.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
