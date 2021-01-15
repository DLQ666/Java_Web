package com.dlq.book.test;

import com.dlq.book.dao.UserDao;
import com.dlq.book.dao.impl.UserDaoImpl;
import com.dlq.book.pojo.User;
import com.dlq.book.service.UserService;
import com.dlq.book.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"admin","123","qwe1@11.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "123456", null)));
    }

    @Test
    public void existUsername() {
        if (userService.existUsername("admin55")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }
    }
}
