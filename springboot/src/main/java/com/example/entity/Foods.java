package com.example.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor     // 使用Lombok
@NoArgsConstructor
@Data
public class Foods {

    @Alias("菜品ID")
    private Integer id;
    @Alias("菜品名称")
    private String name;
    @Alias("菜品描述")
    private String descr;
    @Alias("菜品价格")
    private BigDecimal price;
    @Alias("菜品图片")
    private String img;

}
