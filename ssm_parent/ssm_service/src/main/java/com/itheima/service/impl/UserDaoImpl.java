package com.itheima.service.impl;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public User login(User user) {
        User loginUser = userDao.login(user);
        return loginUser;
    }
}
