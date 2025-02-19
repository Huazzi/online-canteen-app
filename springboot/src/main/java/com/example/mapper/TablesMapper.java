package com.example.mapper;

import com.example.entity.Tables;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TablesMapper {

    void insert(Tables tables);     //    插入一条记录

    void deleteById(Integer id);    //    根据id删除一条记录

    void updateById(Tables tables); //    根据id更新一条记录

    // 根据id查询餐桌
    @Select("select * from tables where id = #{id}")
    Tables selectById(Integer id);

    // 查询所有餐桌
    List<Tables> selectAll(String name);

    // 根据用户id查询记录
    @Select("select * from tables where user_id = #{userId}")
    Tables selectByUserId(Integer userId);

    // 释放餐桌
    @Update("update tables set user_id = null, free = '是' where id = #{id}")
    void removeTable(Integer id);

    // 查询当前所有餐桌信息
    @Select("select * from tables")
    List<Tables> findAll();
}
