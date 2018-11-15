package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.IAccountService;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/login")
    public String login(User loginUser, HttpServletRequest request){
        User user = userService.login(loginUser);
        if(user!=null){
            //登陆成功
            request.getSession().setAttribute("user",user);
            return "redirect:/account/findAll";
        }
        //登录失败
        request.setAttribute("error","用户名或密码错误");
        return "forward:/login.jsp";
    };
}
