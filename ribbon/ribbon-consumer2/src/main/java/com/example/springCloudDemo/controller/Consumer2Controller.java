package com.example.springCloudDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 14:38
 */
@RestController
@RequestMapping(value = "/ribbon-consumer2")
public class Consumer2Controller {

    @Bean
    @LoadBalanced  //实现负载均衡
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping(value = "/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "springcloud") String name) throws IOException {
        ServiceInstance instance = loadBalancer.choose("PROVIDER");
        System.out.println("instance.getUri"+instance.getUri());
        URL url = new URL("http://localhost:" + instance.getPort() + "/ribbon-provider/greeting");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream inputStream = conn.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        reader.close();
        return Observable.just(buffer.toString()).toBlocking().first();
    }
}
