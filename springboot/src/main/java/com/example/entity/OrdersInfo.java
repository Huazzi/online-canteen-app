package com.example.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersInfo{
    @Alias("订单ID")
    private Integer id;
    @Alias("订单内容")
    private String content;
    @Alias("订单编号")
    private String orderNo;
    @Alias("订单时间")
    private String time;
    @Alias("用户名称")
    private String name;
    @Alias("订单总价")
    private BigDecimal total;
    @Alias("订单状态")
    private String status;

}
