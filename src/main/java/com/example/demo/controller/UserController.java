package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.LoginParam;
import com.example.demo.entity.Output;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.util.OutputUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author generator
 * @since 2020-05-27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 用户注册
     * @param loginParam 参数
     * @return 返回数据
     */
    @RequestMapping("/register")
    public Output<String> register(LoginParam loginParam){
        User user = new User();
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        if (StringUtils.isNotBlank(username)) {
            QueryWrapper<User> qw = new QueryWrapper<>();
            qw.eq("username",username);
            if (userService.count(qw) == 0) {
                user.setUsername(username);
                if (StringUtils.isNotBlank(password)) {
                    user.setPassword(password);
                    userService.save(user);
                    return OutputUtil.ok("");
                }
            }
        }
        return OutputUtil.fail(700,"该用户名已存在");
    }

    /**
     * 用户登录
     * @param loginParam 登录参数
     * @return 返回数据
     */
    @RequestMapping("/login")
    public Output<User> login(LoginParam loginParam){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username",loginParam.getUsername());
        User user = userService.getOne(qw);
        if (user != null) {
            if (user.getPassword().equals(loginParam.getPassword())) {
                return OutputUtil.ok(user);
            }
        }
        return OutputUtil.fail(600,"用户名或密码不正确");
    }

}
