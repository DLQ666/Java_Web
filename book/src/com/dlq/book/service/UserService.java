package com.dlq.book.service;

import com.dlq.book.pojo.User;

/**
 *@description:
 *@author: Hasee
 *@create: 2021-01-14 18:12
 */
public interface UserService {

    /**
     * 注册
     * @param user 用户
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user 用户
     * @return 如果返回null ，说明登录失败，返回有值，登录成功
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username 用户名
     * @return 返回true 表示用户名已存在，返回false表示用户名可用
     */
    public boolean existUsername(String username);
}
