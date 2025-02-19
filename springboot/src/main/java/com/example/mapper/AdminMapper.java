package com.example.mapper;

import com.example.entity.Account;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminMapper {

    // 在管理员视图中查找符合条件的账号
    @Select("select id, username, password, name, avatar, role, phone from user where role = 'ADMIN' and username = #{username} ")
    User selectByUsername(String username);

    // 添加
//    void insert(Admin admin);

    // 根据ID删除，等价于将角色换成普通用户
    @Update("update user set role = 'USER' where id = #{id} ")
    void deleteById(Integer id);

    // 根据ID更新
    void updateById(User admin);

    // 根据ID查询管理员
    @Select("select * from view_admins where id = #{id}")
    User selectById(Integer id);

    // 查询所有管理员--实现模糊查询
    List<User> selectAll(String name);

    // 查询所有管理员
//    @Select("select * from view_admins")
    List<Account> findAll();
}
