package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    // 从用户视图中查找
    @Select("select * from view_users where username = #{username}")
    User selectByUsername(String username);

    void insert(User user);

    void deleteById(Integer id);

    void updateById(User user);

    @Select("select * from view_users where id = #{id}")
    User selectById(Integer id);

    List<User> selectAll(String name);

    //查询所有用户
    @Select("select * from user where role = 'USER'")
    List<User> findAll();
}
