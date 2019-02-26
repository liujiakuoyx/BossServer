package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.base.http.DataResponse;
import com.liujiakuo.boss.bean.UserInfo;
import com.liujiakuo.boss.dao.user.User;
import com.liujiakuo.boss.dao.user.UserSeviceImp;
import com.liujiakuo.boss.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
                response = new DataResponse<>(400, "用户不存在");
            } else if (user.getPass().equals(pass)) {
                //登录成功
                response = new DataResponse<>(200, "success");
                response.setData(user);
            } else {
                //密码错误
                response = new DataResponse<>(400, "密码错误");
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
}
