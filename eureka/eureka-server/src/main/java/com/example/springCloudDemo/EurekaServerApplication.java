package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 11:33
 */
@SpringBootApplication
@EnableEurekaServer  //Eureka服务端
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
