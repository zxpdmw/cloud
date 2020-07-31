package com.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.springcloud.handler.CustomerBlockHandler;
import com.example.springcloud.pojo.Payment;
import com.example.springcloud.util.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 09:44
 **/
@RestController
public class RateLimitController {
    @GetMapping("byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名限流测试ok",new Payment(2020,"zzzzzzzzzzz"));
    }

    @GetMapping("customer/blockhandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult customerHandler(){
        return new CommonResult(200,"按资源名限流测试ok",new Payment(2020,"zzzzzzzzzzz"));
    }

    public CommonResult handlerException(BlockException e){
        return new CommonResult(444,e.getClass().getCanonicalName()+"服务不可用");
    }
}
