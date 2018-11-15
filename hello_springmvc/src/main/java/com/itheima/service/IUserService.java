package com.itheima.service;

import com.itheima.domain.User;

public interface IUserService {
    /**
     * 用户登录方法
     * @param user
     * @return
     */
    User login(User user);
}
