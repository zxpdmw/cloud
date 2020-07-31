package com.example.springcloud.mapper;

import com.example.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 15:31
 **/
@Mapper
public interface OrderMapper {
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
