package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "account")
public class AccountContorller {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "/WEB-INF/pages/list.jsp";
    }

    @RequestMapping("/addAccount")
    public String save(ModelAndView modelAndView, Account account, MultipartFile imgFile, HttpServletRequest request) throws IOException {
        //存入转发的地址
        //modelAndView.setViewName("/account/findAll");
        String realPath = request.getSession().getServletContext().getRealPath("/imgs/");
        File file = new File(realPath);
        if (!file.exists()) {
            //如果文件夹不存在就创建文件夹
            file.mkdir();
        }
        //获取上传图片文件的名字
        String filename = imgFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String imgName = uuid + "_" + filename;
        imgFile.transferTo(new File(realPath, imgName));
        //保存文件上传的路径

        //设置图片保存的路径
        String imgPath = request.getContextPath() + "/imgs/" +  imgName;
        //保存图片路径
        account.setImgSrc(imgPath);
        accountService.save(account);
        return "redirect:findAll";

    }


}
