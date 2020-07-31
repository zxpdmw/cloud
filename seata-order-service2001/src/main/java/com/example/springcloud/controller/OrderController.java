package com.example.springcloud.controller;

import com.example.springcloud.domain.Order;
import com.example.springcloud.service.OrderService;
import com.example.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 15:39
 **/
@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

