package com.liujiakuo.boss.dao.user;

import java.util.List;

public interface IUserSevice {
    /**
     * 获取全部
     */
    List<User> findAll();

    /**
     * 插入一个用户
     */
    User insertUser(User user);

    /**
     * 删除
     */
    void deleteUser(User user);

    /**
     * 更新
     */
    User updateUser(User user);

    /**
     * 登录
     */
    User findUserByKey(String key);
}
