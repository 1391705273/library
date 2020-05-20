package com.example.demo.entity;

import lombok.Data;

@Data
public class Account {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;
}
