package com.zhan.app.nearby.service;

import com.zhan.app.nearby.entity.User;
import com.zhan.app.nearby.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zah on 2017/12/20.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public void addUser(User user) {
        userDao.insert(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }
}
