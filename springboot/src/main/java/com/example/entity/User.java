package com.example.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor     // 使用Lombok
@NoArgsConstructor
@Data
public class User extends Account{

    @Alias("用户ID")
    private Integer id;
    @Alias("账号")
    private String username;
    @Alias("密码")
    private String password;
    @Alias("用户昵称")
    private String name;
    @Alias("用户性别")
    private String sex;
    @Alias("联系电话")
    private String phone;
    @Alias("用户角色")
    private String role;
    @Alias("账户余额")
    private BigDecimal account;

}
