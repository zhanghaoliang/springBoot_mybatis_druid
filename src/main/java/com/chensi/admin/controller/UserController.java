package com.chensi.admin.controller;

import com.chensi.admin.model.User;
import com.chensi.admin.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询某一个人
     * @return
     */
    @GetMapping("/select")
    @ResponseBody
    public User selectUserById(){
        User user = this.userService.selectUserById(1);
        return user;
    }

    /**
     * 查询所有人员
     * @return
     */
    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUser(){
        return this.userService.selectAllUser();
    }

    /**
     * 分页查询人员
     * @return
     */
    @GetMapping("/page")
    @ResponseBody
    public PageInfo<User> page(){
        PageInfo<User> userPageInfo = this.userService.queryPage(1, 2);
        System.out.println("总页数=" + userPageInfo.getPages());
        System.out.println("总记录数=" + userPageInfo.getTotal()) ;
        return userPageInfo;
    }

    /**
     * 新增人员
     */
    @GetMapping("/insert")
    public void insert(){
        User u = new User();
        u.setId(4);
        u.setUsername("小张");
        u.setAddress("北京市朝阳区");
        this.userService.insertUser(u);
    }
}
