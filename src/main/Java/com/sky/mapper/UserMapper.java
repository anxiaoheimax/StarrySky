package com.sky.mapper;

import com.sky.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //通过用户名查密码
    @Select("SELECT * FROM USER WHERE Uname=#{Uname} ")
    public User findUser(String Uname);
}
