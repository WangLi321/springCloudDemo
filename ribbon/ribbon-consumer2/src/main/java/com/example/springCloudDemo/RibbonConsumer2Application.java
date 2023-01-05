package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费端
 * 使用Ribbon实现负载均衡
 */
@SpringBootApplication
@EnableEurekaClient
public class RibbonConsumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumer2Application.class, args);
	}

}
