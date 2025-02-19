package com.example.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.entity.Tables;
import com.example.service.TablesService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.beans.Encoder;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Resource
    TablesService tablesService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Tables tables) {
        tablesService.add(tables);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        tablesService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        tablesService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody Tables tables) {
        tablesService.updateById(tables);
        return Result.success();
    }

    @PutMapping("/useTable")
    public Result useTable(@RequestBody Tables tables) {
        tablesService.useTable(tables);
        return Result.success();
    }

    // 释放餐桌
    @PutMapping("/removeTable")
    public Result removeTable(@RequestBody Tables tables) {
        tablesService.removeTable(tables);
        return Result.success();
    }

    /**
     * 查询单个
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Tables tables = tablesService.selectById(id);
        return Result.success(tables);
    }

    /**
     * 根据用户id查询
     */
    @GetMapping("/selectByUserId/{userId}")
    public Result selectByUserId(@PathVariable Integer userId) {
        Tables tables = tablesService.selectByUserId(userId);
        return Result.success(tables);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(String name) {
        List<Tables> list = tablesService.selectAll(name);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            String name,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Tables> pageInfo = tablesService.selectPage(name, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/export")
    public void exportData(@RequestParam(required = false) String userName,
                           @RequestParam(required = false) String name,
                           HttpServletResponse response) throws IOException {
        ExcelWriter excelWriter = ExcelUtil.getWriter(true); // 创建一个ExcelWriter对象

        // 获取餐桌信息
        List<Tables> list = tablesService.findAll();
        // 将数据写入Excel
        excelWriter.write(list, true);
        // 设置文件格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        // 设置响应头，告诉浏览器下载文件
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("餐桌信息表", StandardCharsets.UTF_8) + ".xlsx");

        ServletOutputStream outputStream = response.getOutputStream(); // 获取输出流
        excelWriter.flush(outputStream, true); // 将数据写入输出流
        outputStream.flush();
        excelWriter.close(); // 关闭ExcelWriter
        outputStream.close();// 关闭输出流


    }

}
