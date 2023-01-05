package com.example.springCloudDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 14:43
 */
@RestController
@RequestMapping(value = "/ribbon-consumer3")
public class Consumer3Controller {

    @Bean
    @LoadBalanced  //实现负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "springcloud") String name){
        String greeting = this.restTemplate.getForObject("http://PROVIDER/ribbon-provider/greeting", String.class);
        return String.format("%s, %s", name, greeting);
    }
}
