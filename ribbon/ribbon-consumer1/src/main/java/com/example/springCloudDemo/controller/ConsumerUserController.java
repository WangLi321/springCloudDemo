package com.example.springCloudDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 14:32
 */
@RestController
@RequestMapping(value = "/ribbon-consumer1")
public class ConsumerUserController {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "springcloud") String name){
        String greeting = this.restTemplate.getForObject("http://localhost:8082/ribbon-provider/greeting", String.class);
        return String.format("%s, %s", name, greeting);
    }
}
