package com.example.springCloudDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 15:12
 */
@RestController
@RequestMapping(value = "/hystrix-server")
public class HystrixServerController {

    @RequestMapping(value = "/getbook")
    public String getBooks(){
        List<String> list = Arrays.asList("Java编程实战","SpringBoot入门到精通","Java从入门到放弃","SpringCloud入门实战");
        Random random = new Random();
        String book = list.get(random.nextInt(list.size()));
        System.out.println("图书 = <<" + book + ">>");
        return "图书：" + book ;
    }
}
