package com.example.springCloudDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 11:18
 */
@RestController
public class EurekaClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * //http://localhost:8081/spring-cloud/eureka-client
     * @param applicationName
     * @return
     */
    @RequestMapping("/spring-cloud/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
