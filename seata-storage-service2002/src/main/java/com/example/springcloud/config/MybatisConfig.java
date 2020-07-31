package com.example.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud
 * @description:
 * @author: ZXP
 * @create: 2020-07-10 15:46
 **/
@Configuration
@MapperScan("com.example.springcloud.mapper")
public class MybatisConfig {
}
