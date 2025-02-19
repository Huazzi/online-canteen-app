package com.example.controller;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.User;
import com.example.service.AdminService;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    AdminService adminService;

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        adminService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        adminService.updateById(user);
        return Result.success();
    }

    /**
     * 查询单个
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        User admin = adminService.selectById(id);
        return Result.success(admin);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(String name) {
        List<User> list = adminService.selectAll(name);
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
        PageInfo<User> pageInfo = adminService.selectPage(name, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/export")
    public void exportData(@RequestParam(required = false) String userName,
                           @RequestParam(required = false) String name,
                           HttpServletResponse response) throws IOException {

        ExcelWriter excelWriter = ExcelUtil.getWriter(true); // 创建ExcelWriter

        /* 全部导出 */
        List<Account> list = new ArrayList<>();
        list = adminService.findAll();
        excelWriter.write(list, true); // 写入数据

        // 设置写入格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("管理员信息表", StandardCharsets.UTF_8) + ".xlsx");

        ServletOutputStream outputStream = response.getOutputStream(); // 获取输出流
        excelWriter.flush(outputStream, true); // 将数据写入输出流
        outputStream.flush();
        excelWriter.close(); // 关闭ExcelWriter
        outputStream.close();// 关闭输出流
    }

}
