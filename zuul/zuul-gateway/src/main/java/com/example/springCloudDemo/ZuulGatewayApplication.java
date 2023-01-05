package com.example.springCloudDemo;

import com.example.springCloudDemo.filter.ZuulSimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayApplication {

	/**
	 * 引入zuul过滤器到容器中
	 */
	@Bean
	public ZuulSimpleFilter zuulSimpleFilter(){
		return new ZuulSimpleFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

}
