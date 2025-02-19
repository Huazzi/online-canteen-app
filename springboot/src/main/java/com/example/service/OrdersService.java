package com.example.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.entity.Orders;
import com.example.entity.OrdersInfo;
import com.example.mapper.OrdersMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {

    @Resource
    OrdersMapper ordersMapper;

    // 添加订单
    @Transactional // 事务管理  保证数据的一致性
    public void add(Orders orders) {
        String orderNo = IdUtil.fastSimpleUUID(); // 获取唯一的订单号
        orders.setOrderNo(orderNo); // 设置订单号
        orders.setTime(DateUtil.now());  // 当前的年月日 时分秒

        // 将订单信息封装到 Map 中
        Map<String, Object> params = new HashMap<>();
        params.put("mode", "INSERT");   // 将存储过程的模式设置为‘插入’
        params.put("orderId", null); // 主键自增，不需要设置
        params.put("content", orders.getContent());
        params.put("total", orders.getTotal());
        params.put("userId", orders.getUserId());
        params.put("time", orders.getTime());
        params.put("status", orders.getStatus());
        params.put("tableId", orders.getTableId());
        params.put("orderNo", orders.getOrderNo());
        params.put("userName", orders.getUserName());
        // 调用 Mapper 方法
        ordersMapper.insert(params);
    }

    // 删除订单
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    // 批量删除
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }

    // 更新订单
    @Transactional // 事务管理  保证数据的一致性
    public void updateById(Orders orders) {

        // 将订单信息封装到 Map 中
        Map<String, Object> params = new HashMap<>();
        params.put("mode", "UPDATE");   // 将存储过程的模式设置为‘更新’
        params.put("orderId", orders.getId());
        params.put("content", orders.getContent());
        params.put("total", orders.getTotal());
        params.put("userId", orders.getUserId());
        params.put("time", orders.getTime());
        params.put("status", orders.getStatus());
        params.put("tableId", orders.getTableId());
        params.put("orderNo", orders.getOrderNo());
        // 调用 Mapper 方法
        ordersMapper.insert(params);
    }

    // 根据id查询订单
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    // 根据用户名和用户id查询订单
    public List<Orders> selectAll(String userName, Integer userId) {
        return ordersMapper.selectAll(userName, userId);
    }

    // 分页查询
    public PageInfo<Orders> selectPage(String userName, Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = this.selectAll(userName, userId);
        return PageInfo.of(list);
    }

    // 查询所有订单信息
    public List<OrdersInfo> selectOrdersView() {
        return ordersMapper.selectOrdersView();
    }
}
