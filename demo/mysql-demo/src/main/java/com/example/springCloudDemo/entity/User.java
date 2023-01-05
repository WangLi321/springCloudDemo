package com.example.springCloudDemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 13:28
 */
@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Date createdTime;
}
