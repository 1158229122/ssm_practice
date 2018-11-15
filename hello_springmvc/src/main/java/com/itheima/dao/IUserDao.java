package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface IUserDao {
    /**
     * 用户登录方法
     * @param user
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User login(User user);
}
