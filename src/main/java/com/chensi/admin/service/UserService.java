package com.chensi.admin.service;

import com.chensi.admin.model.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    User selectUserById(Integer id);
    List<User> selectAllUser();
    PageInfo<User> queryPage(Integer pageNum,Integer pageSize);
    void insertUser(User u);
}
