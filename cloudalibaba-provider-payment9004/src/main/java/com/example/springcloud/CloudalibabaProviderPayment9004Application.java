package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaProviderPayment9004Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9004Application.class, args);
    }

}
