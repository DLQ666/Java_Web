package com.dlq.book.test;

import com.dlq.book.dao.UserDao;
import com.dlq.book.dao.impl.UserDaoImpl;
import com.dlq.book.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "123456") == null) {
            System.out.println("用户或密码错误，登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        User user = new User(null, "qwe123", "123456", "qwe@qq.com");
        System.out.println(userDao.saveUser(user));
    }
}
