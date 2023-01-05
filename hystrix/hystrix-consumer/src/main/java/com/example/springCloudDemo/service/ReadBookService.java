package com.example.springCloudDemo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 16:12
 */
@Service
public class ReadBookService {

    /**
     * 如果服务发生异常，就调用默认的collbackMethod方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "collbackMethod")
    public String getBook(){
        RestTemplate restTemplate = new RestTemplate();
        URI uri = URI.create("http://localhost:8010/hystrix-server/getbook");
        return restTemplate.getForObject(uri, String.class);
    }

    /**
     * 熔断回调方法
     * 如果服务端挂了，执行熔断机制，调用此方法
     * @return
     */
    public String collbackMethod(){
        return "哎呀，服务端挂了";
    }

}
