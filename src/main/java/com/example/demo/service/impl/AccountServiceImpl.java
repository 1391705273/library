package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    public AccountMapper accountMapper;
    /**
     * 注册新用户
     * @param account
     * @return
     */
    @Override
    public String insertAccount(Account account) {
        Integer counst = accountMapper.insertAccount(account);
        if (counst > 0 ){
            return "注册成功,请前往登录！";
        }
        return "注册失败,请查看用户名密码是否过长.";
    }

    /**
     * 删除账户信息
     * @param id
     * @return
     */
    @Override
    public String delAccount(Integer id) {
        Integer counst = accountMapper.delAccount(id);
        if (counst > 0 ){
            return "该账户已删除！";
        }
        return "删除失败.";
    }

    /**
     * 修改账户信息
     * @param account
     * @return
     */
    @Override
    public String updateAccount(Account account) {
        Integer counst = accountMapper.updateAccount(account);
        if (counst > 0 ){
            return "该账户已修改成功！";
        }
        return "修改失败.";
    }

    /**
     * 查询所有已成功注册账户
     * @return
     */

    @Override
    public String getAccount(String account, String password) {
        Integer count = accountMapper.getAccount(account, password);
        if (count > 0) {
            return "登录成功！";
        }
        return "用户名或密码错误！！";
    }
}
