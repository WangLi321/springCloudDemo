package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 11:18
 */
//Eureka client是客户端API，用来注册服务到Eureka server。
@SpringBootApplication
@EnableDiscoveryClient   //Eureka客户端
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

}

