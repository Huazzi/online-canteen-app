package com.example.controller;

import com.example.common.Result;
import com.example.common.RoleEnum;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.service.AdminService;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @Resource
    AdminService adminService;

    @Resource
    UserService userService;

    // 默认请求路径
    @GetMapping("/")
    public Result hello() {
        return Result.success();
    }

    // 登录请求路径
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            account = adminService.login(account); // 调用管理员登录方法
        } else if (RoleEnum.USER.name().equals(account.getRole())) {
            account = userService.login(account);  // 调用用户登录方法
        } else {
            return Result.error("您的参数输入错误");
        }
        return Result.success(account);
    }

    // 注册请求路径
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (RoleEnum.USER.name().equals(user.getRole())) {
            userService.register(user); // 调用用户注册方法
        } else {
            return Result.error("您的参数输入错误");
        }
        return Result.success();
    }

}
