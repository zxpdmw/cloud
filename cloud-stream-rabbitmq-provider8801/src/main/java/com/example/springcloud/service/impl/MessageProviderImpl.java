package com.example.springcloud.service.impl;

import com.example.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-09 11:38
 **/
@EnableBinding(Source.class)
@Service
public class MessageProviderImpl implements MessageProvider {
    @Resource
    MessageChannel output;
    @Override
    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println("消息已发送");
        return s;
    }
}
