package com.example.springCloudDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 13:53
 */
@RestController
@RequestMapping(value = "/redis-demo")
public class RedisDemoController {
    @Autowired
    public RedisTemplate<String,String> redisTemplate;

    @RequestMapping(value = "/redisTest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String redisTest(){
        redisTemplate.opsForValue().set("myKey", "myValue",100, TimeUnit.SECONDS);
        String myKey = redisTemplate.opsForValue().get("myKey");
        System.out.println(myKey);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("myKey",myKey);
        System.out.println("myKey:"+ myKey);
        return redisTemplate.opsForValue().get("myKey");
    }
}
