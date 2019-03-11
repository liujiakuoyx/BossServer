package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.dao.admin.Admin;
import com.liujiakuo.boss.dao.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/doLogin.do")
    public Admin doLogin(HttpServletRequest request) {
        String uid = request.getParameter("uid");
        String upass = request.getParameter("upass");
        Admin admin = adminService.login(uid, upass);
        if (admin == null) {
            return null;
        } else {
            return admin;
        }
    }
}
