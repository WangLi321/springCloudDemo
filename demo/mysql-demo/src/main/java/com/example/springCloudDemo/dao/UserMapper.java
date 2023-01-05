package com.example.springCloudDemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springCloudDemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangli
 * @Description
 * @date 2023/1/5 13:11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
