package com.dlq.book.service.impl;

import com.dlq.book.dao.UserDao;
import com.dlq.book.dao.impl.UserDaoImpl;
import com.dlq.book.pojo.User;
import com.dlq.book.service.UserService;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-14 18:13
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username) == null){
            //等于null，说明没查询到，表示可用
            return false;
        }
        return true;
    }
}
