package com.example.springcloud.mapper;


import com.example.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: cloud2020
 * @description:
 * @author: ZXP
 * @create: 2020-07-06 08:49
 **/
public interface PaymentMapper{
    @Select("select *from payment where id=#{id}")
    Payment getById(@Param("id") Integer id);

    @Insert("insert into payment(serial) values(#{serial})")
    int insertPayment(Payment payment);


}
