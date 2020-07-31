package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamRabbitmqProvider8801Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamRabbitmqProvider8801Application.class, args);
    }

}
