package com.sky.service;

import com.sky.mapper.UserMapper;
import com.sky.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public User findUser(String Uname){
       return userMapper.findUser(Uname);
    }
}
