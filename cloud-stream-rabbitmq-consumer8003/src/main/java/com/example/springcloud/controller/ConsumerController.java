package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 12:12
 **/
@Component
@EnableBinding(value = Sink.class)
public class ConsumerController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void consumer(Message<String> message) {
        System.out.println("我是消费者二号" + message.getPayload() + "\t" + port);
    }
}
