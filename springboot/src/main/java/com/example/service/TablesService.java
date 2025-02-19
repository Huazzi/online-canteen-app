package com.example.service;

import com.example.entity.Tables;
import com.example.exception.CustomException;
import com.example.mapper.TablesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesService {

    @Resource
    TablesMapper tablesMapper;


    // 添加餐桌
    public void add(Tables tables) {
        tablesMapper.insert(tables);
    }

    // 根据id删除餐桌
    public void deleteById(Integer id) {
        tablesMapper.deleteById(id);
    }

    // 批量删除
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }

    // 更新餐桌信息
    public void updateById(Tables tables) {
        if ("是".equals(tables.getFree())) {
            tables.setUserId(null);  // 清除占用的顾客信息
        }
        tablesMapper.updateById(tables);
    }

    // 根据id查询餐桌
    public Tables selectById(Integer id) {
        return tablesMapper.selectById(id);
    }

    // 查询所有餐桌
    public List<Tables> selectAll(String name) {
        return tablesMapper.selectAll(name);
    }

    // 分页查询
    public PageInfo<Tables> selectPage(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tables> list = this.selectAll(name);
        return PageInfo.of(list);
    }

    // 预定餐桌
    public void useTable(Tables tables) {
        // 先查询当前的用户有没有占用餐桌
        Tables dbTables = tablesMapper.selectByUserId(tables.getUserId());
        if (dbTables != null && !dbTables.getId().equals(tables.getId())) {
            throw new CustomException("您已经预定了其他餐桌");
        }
        tables.setFree("否");
        this.updateById(tables);
    }

    // 根据用户id查询餐桌
    public Tables selectByUserId(Integer userId) {
        return tablesMapper.selectByUserId(userId);
    }

    // 释放餐桌
    public void removeTable(Tables tables) {
        tablesMapper.removeTable(tables.getId());
    }

    // 查询所有餐桌
    public List<Tables> findAll() {
        return tablesMapper.findAll();
    }

}
