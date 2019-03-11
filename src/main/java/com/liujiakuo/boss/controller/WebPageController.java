package com.liujiakuo.boss.controller;

import com.liujiakuo.boss.dao.admin.Admin;
import com.liujiakuo.boss.dao.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试jsp页面
 */
@Controller
@RequestMapping("/web")
public class WebPageController {

    @RequestMapping("/login")
    public String loginPage() {
        return "admin_login";
    }
}
