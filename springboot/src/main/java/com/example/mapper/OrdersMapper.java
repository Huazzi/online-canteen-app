package com.example.mapper;

import com.example.entity.Orders;
import com.example.entity.OrdersInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrdersMapper {

    // 调用数据库存储过程 插入订单
    void insert(Map<String, Object> params);

    // 调用数据库存储过程 删除订单
    void deleteById(Integer id);

    // 调用数据库存储过程 更新订单
    void updateById(Map<String, Object> params);

    // 调用存储过程，根据id查询订单
    @Select("CALL get_user_orders(#{id})")
    Orders selectById(Integer id);

    // 根据用户名和用户id查询订单
    List<Orders> selectAll(@Param("userName") String userName, @Param("userId") Integer userId);

    // 从定义好的视图中查询当前所需要的所有订单信息
    @Select("select * from view_orders_info")
    List<OrdersInfo> selectOrdersView();
}
