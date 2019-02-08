package com.liujiakuo.boss.dao.user;

import com.liujiakuo.boss.bean.user.User;
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
}
