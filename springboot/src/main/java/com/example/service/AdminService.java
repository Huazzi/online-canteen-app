package com.example.service;

import com.example.entity.Account;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;

    // 管理员登录
    public Account login(Account account) {
        String username = account.getUsername();
        // 根据账号查询数据
        Account dbAdmin = adminMapper.selectByUsername(username);
        if (dbAdmin == null) {  // 数据库中不存在该账号
            throw new CustomException("账号不存在");
        }
        // 校验密码
        if (!dbAdmin.getPassword().equals(account.getPassword())) {
            throw new CustomException("账号或者密码错误");
        }

        // 账号匹配成功
        return dbAdmin;
    }

//    // 添加管理员
//    public void add(Admin admin) {
//        Admin dbAdmin = adminMapper.selectByUsername(admin.getUsername());
//        if (dbAdmin != null) {
//            throw new CustomException("账号已存在");
//        }
//        if (ObjectUtil.isEmpty(admin.getPassword())) {
//            admin.setPassword("admin");  // 默认密码
//        }
//        if (ObjectUtil.isEmpty(admin.getName())) {
//            admin.setName(admin.getUsername());
//        }
//        admin.setRole(RoleEnum.ADMIN.name());
//        adminMapper.insert(admin);
//    }

    // 根据id删除
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

//    批量删除
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            this.deleteById(id);
        }
    }

//    根据ID更新
    public void updateById(User admin) {
        adminMapper.updateById(admin);
    }

//    根据ID查询
    public User selectById(Integer id) {
        return adminMapper.selectById(id);
    }

//    查询全部
    public List<User> selectAll(String name) {
        return adminMapper.selectAll(name);
    }

//    分页查询
    public PageInfo<User> selectPage(String name, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = this.selectAll(name);
        return PageInfo.of(list);
    }

    // 查询当前的所有管理员信息
    public List<Account> findAll() {
        return adminMapper.findAll();
    }
}
