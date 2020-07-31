package com.example.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-08 10:28
 **/
@Service
public class PaymentService {

    public String paymentInfo(Integer id) {

        return "线程池" + Thread.currentThread().getName() + "paymentInfo Ok id" + id + "\t" + "哈哈";
    }

    @HystrixCommand(fallbackMethod = "fallbackHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentError(Integer id) throws InterruptedException {
//        int a=10/0;
        TimeUnit.MILLISECONDS.sleep(3000);
        return "线程池" + Thread.currentThread().getName() + "系统运行正常" + id + "\t" + "哈哈";
    }


    @HystrixCommand(fallbackMethod = "payment_circuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String circuitBreakerTest(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String s = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功,返回流水号" + s;
    }

    public String fallbackHandler(Integer id) throws InterruptedException {
        return "线程池" + Thread.currentThread().getName() + "系统繁忙,请稍后再试!!!";
    }

    public String payment_circuitBreaker_fallback(Integer id) {
        return "id不能为负数,请重试+" + id;
    }

}
