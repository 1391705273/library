package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

    @Autowired
    public AccountService accountService;

    /**
     * 登录界面
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 注册界面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * 首页
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    /**
     * 新增用户
     * @param account
     * @return
     */
    @PostMapping("/insertAccount")
    @ResponseBody
    public String insertAccount(Account account){
        return accountService.insertAccount(account);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @PostMapping("/delAccount")
    @ResponseBody
    public String delAccount(Integer id){
        return accountService.delAccount(id);
    }

    /**
     * 更新用户数据
     * @param account
     * @return
     */
    @PostMapping("/updateAccount")
    @ResponseBody
    public String updateAccount(Account account){
        return accountService.updateAccount(account);
    }

    /**
     * 查询用户列表
     * @param
     * @return
     */
    @PostMapping("/getAccount")
    @ResponseBody
    public String getAccount(String account,String password) {
        return accountService.getAccount(account, password);
    }
}
