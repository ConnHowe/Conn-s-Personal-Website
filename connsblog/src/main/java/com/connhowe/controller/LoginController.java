package com.connhowe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        if (username.equals("admin") && password.equals("ConnHowe")) {
            session.setAttribute("loginUser", username);
            return "redirect:/admin";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

}
