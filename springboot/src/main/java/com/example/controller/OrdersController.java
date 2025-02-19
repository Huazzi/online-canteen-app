package com.example.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.entity.Orders;
import com.example.entity.OrdersInfo;
import com.example.service.OrdersService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    OrdersService ordersService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Orders orders) {
        ordersService.add(orders);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        ordersService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        ordersService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody Orders orders) {
        ordersService.updateById(orders);
        return Result.success();
    }

    /**
     * 查询单个
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
       Orders orders = ordersService.selectById(id);
        return Result.success(orders);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(String userName, Integer userId) {
        List<Orders> list = ordersService.selectAll(userName, userId);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            String userName,
            Integer userId,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Orders> pageInfo = ordersService.selectPage(userName, userId, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    // 导出信息表
    @GetMapping("/export")
    public void exportData(@RequestParam(required = false) String userName,
                           @RequestParam(required = false) String name,
                           HttpServletResponse response) throws IOException {
        // 创建ExcelWriter
        ExcelWriter excelWriter = ExcelUtil.getWriter(true);

        /* 全部导出 */
        List<OrdersInfo> list;
        list = ordersService.selectOrdersView();
        excelWriter.write(list, true); // 写入数据

        // 设置写入格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("订单信息表", StandardCharsets.UTF_8) + ".xlsx");

        ServletOutputStream outputStream = response.getOutputStream(); // 获取输出流
        excelWriter.flush(outputStream, true); // 将数据写入输出流
        outputStream.flush();
        excelWriter.close(); // 关闭ExcelWriter
        outputStream.close();// 关闭输出流
    }
}
