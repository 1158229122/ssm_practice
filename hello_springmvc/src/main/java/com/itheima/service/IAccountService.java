package com.itheima.service;

import com.itheima.domain.Account;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     */
    void  save(Account account);
}
