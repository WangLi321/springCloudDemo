package com.example.springCloudDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangli
 * @Description 智能路由
 * @date 2023/1/5 16:34
 */
@RestController
@RequestMapping("/zuul-book")
public class BookController {

    @RequestMapping("/available")
    public String available(){
        return "available！" ;
    }

    @RequestMapping("/checked-out")
    public String checkedout(){
        return "checked-out!" ;
    }


}
