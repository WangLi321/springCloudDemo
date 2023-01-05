package com.example.springCloudDemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springCloudDemo.dao.UserMapper;
import com.example.springCloudDemo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 13:18
 */
@RestController
@Api(value = "用户接口",tags = "用户接口")
@RequestMapping(value = "/mysql-demo")
public class MysqlDemoController {

    @Resource
    private UserMapper userMapper;

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addNewUser(@RequestBody User user){
        User u1 = new User();
        u1.setUsername(user.getUsername());
        u1.setPassword(user.getPassword());
        u1.setEmail(user.getEmail());
        u1.setCreatedTime(new Date());
        userMapper.insert(u1);
        return "Saved";
    }

    @ApiOperation(value = "获取所有用户")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> getAllUsers(){
        return userMapper.selectList(new QueryWrapper<>());
    }

}
