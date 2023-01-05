package com.example.springCloudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 12:18
 */
@SpringBootApplication
@EnableEurekaClient
public class MysqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlDemoApplication.class, args);
	}

}
