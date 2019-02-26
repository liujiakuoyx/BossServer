package com.liujiakuo.boss.dao.user;

import com.liujiakuo.boss.bean.UserInfo;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeviceImp implements IUserSevice {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserByKey(String key) {
        List<User> userList = userRepository.findUserByKey(key);
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public UserInfo findUserById(String id) {
        if (DataUtils.isEmpty(id)) {
            return null;
        }
        User user = userRepository.findUserById(id);
        return convertData(user);
    }

    /**
     * 数据转换
     */
    private UserInfo convertData(User user) {
        if (user == null) {
            return null;
        }
        UserInfo bean = new UserInfo();
        bean.setUid(String.valueOf(user.getID()));
        bean.setNick(user.getNick());
        bean.setPost(user.getPost());
        bean.setHeadUrl(user.getHeadUrl());
        return bean;
    }
}
