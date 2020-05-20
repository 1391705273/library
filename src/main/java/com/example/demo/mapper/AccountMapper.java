package com.example.demo.mapper;

import com.example.demo.entity.Account;
import javafx.util.converter.IntegerStringConverter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    // 注册用户名
    Integer insertAccount(Account account);

    // 删除账号
    Integer delAccount(Integer id);

    // 更新账户信息
    Integer updateAccount(Account account);

    // 查询有无账户
    Integer getAccount(String account,String password);
}
