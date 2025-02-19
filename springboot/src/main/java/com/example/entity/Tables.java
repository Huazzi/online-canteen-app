package com.example.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor     // 使用Lombok
@NoArgsConstructor
@Data
public class Tables {

    @Alias("餐桌ID")
    private Integer id;
    @Alias("餐桌编号")
    private String no;
    @Alias("餐桌类型")
    private String unit;
    @Alias("餐桌状态")
    private String free;
    @Alias("使用餐桌的用户ID")
    private Integer userId;
    @Alias("使用餐桌的用户名")
    private String userName;

}
