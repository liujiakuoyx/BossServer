package com.liujiakuo.boss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试jsp页面
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}
