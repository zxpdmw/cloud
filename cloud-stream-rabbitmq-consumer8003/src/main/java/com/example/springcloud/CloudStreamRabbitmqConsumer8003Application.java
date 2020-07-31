package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitmqConsumer8003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqConsumer8003Application.class, args);
    }

}
