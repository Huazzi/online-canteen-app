package com.example.entity;

import cn.hutool.core.annotation.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单信息
 */
@AllArgsConstructor     // 使用Lombok
@NoArgsConstructor
@Data
public class Orders {

    @Alias("订单ID")
    private Integer id;
    @Alias("订单内容")
    private String content;
    @Alias("订单总价")
    private BigDecimal total;
    @Alias("用户ID")
    private Integer userId;
    @Alias("订单时间")
    private String time;
    @Alias("订单状态")
    private String status;
    @Alias("餐桌ID")
    private Integer tableId;
    @Alias("订单编号")
    private String orderNo;
    @Alias("用户名称")
    private String userName;

}
