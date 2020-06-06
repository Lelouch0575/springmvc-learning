package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    //跳转到登陆页面
    @RequestMapping("/main")
    public String main() throws Exception {
        return "main";
    }

    //跳转到成功页面
    @RequestMapping("/gologin")
    public String gologin() throws Exception {
        return "login";
    }

    //登陆提交
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password)throws Exception {
        // 向session记录用户身份信息
        System.out.println("接收前端==="+username);
        session.setAttribute("userLoginInfo", username);
        return "main";
    }

    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session) throws Exception {
        // session 过期
        session.invalidate();
        return "login";
    }
}