package com.example.springCloudDemo.controller;

import com.example.springCloudDemo.service.ReadBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 16:15
 */
@RestController
@EnableCircuitBreaker
@RequestMapping(value = "/hystrix-consumer")
public class HystrixConsumerController {

    @Autowired
    ReadBookService readBookService;

    RestTemplate restTemplate = new RestTemplate();

    /**
     * 正常调用，不使用熔断
     * @return
     */
    @RequestMapping(value = "/common")
    public String readBook(){
        String bookStr = restTemplate.getForObject("http://localhost:8010/hystrix-server/getbook", String.class);
        return bookStr;
    }

    /**
     * 正常调用，不使用熔断
     * @return
     */
    @RequestMapping(value = "/useHystrix")
    public String getBookList(){
        return readBookService.getBook();
    }

}
