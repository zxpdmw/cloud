package com.example.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.springcloud.util.CommonResult;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 10:02
 **/
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"用户自定义的BlockHandler             ");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"用户自定义的BlockHandler             ");
    }
}
