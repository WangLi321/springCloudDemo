package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费端
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixConsumerApplication.class, args);
	}

}
