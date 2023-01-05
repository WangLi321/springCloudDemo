package com.example.springCloudDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 14:24
 */
@RestController
@RequestMapping(value = "/ribbon-provider")
public class ProviderController {

    /**
     * 随机问候语
     *
     * @return
     */
    @RequestMapping(value = "/greeting")
    public String greet(){
        List<String> greetins = Arrays.asList("你好！","早上好！","下午好!", "晚上好！", "晚安");
        Random random = new Random();

        String str = greetins.get(random.nextInt(5));
        System.out.println("provider greeting str = " + str);
        return str;
    }

}
