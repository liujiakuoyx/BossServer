package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.base.http.DataResponse;
import com.liujiakuo.boss.base.http.MessageResponse;
import com.liujiakuo.boss.bean.UserInfo;
import com.liujiakuo.boss.dao.user.User;
import com.liujiakuo.boss.dao.user.UserSeviceImp;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSeviceImp userSeviceImp;

    /**
     * 登入验证
     * parameter key 用户账号
     * parameter pass 用户密码
     */
    @RequestMapping("/login")
    public DataResponse<User> login(HttpServletRequest request) {
        DataResponse<User> response = null;
        String userKey = request.getParameter("key");
        String pass = request.getParameter("pass");
        if (DataUtils.isEmpty(userKey) || DataUtils.isEmpty(pass)) {
            //请求参数错误
            response = new DataResponse<>(300, "参数错误");
        } else {
            User user = userSeviceImp.findUserByKey(userKey);
            if (user == null) {
                //用户不存在
                response = new DataResponse<>(4000, "用户不存在");
            } else if (user.getPass().equals(pass)) {
                //登录成功
                response = new DataResponse<>(200, "success");
                response.setData(user);
            } else {
                //密码错误
                response = new DataResponse<>(5000, "密码错误");
            }
        }
        return response;
    }

    @RequestMapping("/getUserInfo")
    public DataResponse<UserInfo> getUserInfo(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        if (DataUtils.isEmpty(uid)) {
            return new DataResponse<>(300, "parameter error");
        }
        UserInfo userInfo = userSeviceImp.findUserById(uid);
        DataResponse<UserInfo> response = new DataResponse<>(200, "success");
        response.setData(userInfo);
        return response;
    }

    /**
     * code：
     * 2000 success
     * 2001 账户已存在
     * 2002 参数错误
     */
    @PostMapping("/register")
    public MessageResponse register(@RequestBody User userInfo) {
        if (userInfo == null || DataUtils.isEmpty(userInfo.getKey())) {
            return new MessageResponse(2002, "参数错误");
        }
        User user = userSeviceImp.findUserByKey(userInfo.getKey());
        if (user != null) {
            return new MessageResponse(2001, "用户已存在");
        } else {
            //插入用户
            userSeviceImp.insertUser(user);
            return new MessageResponse(2000, "注册成功");
        }
    }
}
