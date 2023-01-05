package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费者
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumer1Application.class, args);
	}

}
