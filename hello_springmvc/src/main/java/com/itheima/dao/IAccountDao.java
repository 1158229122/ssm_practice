package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 账户的持久层
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     */
    @Insert("insert into account(name,money,imgSrc) values(#{name},#{money},#{imgSrc})")
     void  save(Account account);
}
