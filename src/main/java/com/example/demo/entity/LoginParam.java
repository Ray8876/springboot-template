package com.example.demo.entity;

import lombok.Data;


/**
 * 登录参数
 */
@Data
public class LoginParam {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
