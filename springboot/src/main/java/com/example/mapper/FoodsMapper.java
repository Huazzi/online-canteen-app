package com.example.mapper;

import com.example.entity.Foods;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FoodsMapper {

    void insert(Foods foods);

    void deleteById(Integer id);

    void updateById(Foods foods);

    @Select("select * from foods where id = #{id}")
    Foods selectById(Integer id);

    List<Foods> selectAll(String name);

    // 查询所有菜品
    @Select("select * from foods")
    List<Foods> findAll();
}
