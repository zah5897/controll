package com.zhan.app.nearby.controller;

import com.zhan.app.nearby.entity.User;
import com.zhan.app.nearby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zah on 2017/12/21.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public boolean addUser(User user) {
        userService.addUser(user);
        return true;
    }

    @RequestMapping("/modify")
    public boolean updateUser(User user) {
        userService.updateUser(user);
        return true;
    }
}
