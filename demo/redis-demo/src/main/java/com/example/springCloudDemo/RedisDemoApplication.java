package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;


@SpringBootApplication
@EnableEurekaClient
public class RedisDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}
}
