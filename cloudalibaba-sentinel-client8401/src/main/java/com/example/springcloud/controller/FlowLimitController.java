package com.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 21:06
 **/
@RestController
public class FlowLimitController
{
    @SentinelResource("A")
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @SentinelResource(value = "B",blockHandler = "blockHandler")
    @GetMapping("/testB")
    public String testB(
            @RequestParam(value = "p1",required = false)String p1,
            @RequestParam(value = "p2",required = false)String p2) {

        return "------testB";
    }

    public String blockHandler(String p1, String p2, BlockException blockException){
        return "blockHandler                 ";

    }



}