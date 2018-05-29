package com.chensi.admin.service.impl;

import com.chensi.admin.mapper.UserMapper;
import com.chensi.admin.model.User;
import com.chensi.admin.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Integer id) {
        User user = this.userMapper.selectByPrimaryKey(id);
        return user;
    }


    public List<User> selectAllUser(){
        List<User> users = this.userMapper.selectAllUser();
        return users;
    }

    @Override
    public PageInfo<User> queryPage(Integer pageNum, Integer pageSize) {
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        //PageHelper会自动拦截到下面这查询sql
        this.userMapper.selectAllUser();
        return page.toPageInfo();
    }

    //注意：方法的@Transactional会覆盖类上面声明的事务
    //Propagation.REQUIRED ：有事务就处于当前事务中，没事务就创建一个事务
    //isolation=Isolation.DEFAULT：事务数据库的默认隔离级别
    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
    public void insertUser(User u) {
        int insert = this.userMapper.insert(u);
        //如果类上面没有@Transactional,方法上也没有，哪怕throw new RuntimeException,数据库也会成功插入数据
        //throw new RuntimeException("测试插入事务");
    }
}
