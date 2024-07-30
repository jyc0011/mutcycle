package com.mut.cycle.controller;
import com.mut.cycle.service.LoginService;
import com.mut.cycle.service.EmailService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    EmailService emailService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("log_stat")=="login"){
            return "redirect:/";
        }
        else {
            return "login/login";
        }
    }
    @PostMapping("/login/check")
    public String loginCheck(@RequestParam String id, @RequestParam String password, HttpSession session, Model model) {
        return "login/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(HttpSession session) {
        return "login/register";
    }


    @PostMapping("/register/idcheck")
    public boolean idCheck() {
        return true;
    }

    @PostMapping("/register/emailcheck/send")
    @ResponseBody
    public Map<String, Object> emailCheckSend(@RequestParam("email") String email, HttpSession session) {
        var map = new HashMap<String, Object>();
        return map;
    }


    @PostMapping("/register/emailcheck/check")
    public boolean emailCheck(@RequestParam("code") String code, HttpSession session) {
        return true;
    }

    @PostMapping("/register/ok")
    public String registerOk() {
        return "redirect:/login";
    }

    @GetMapping("/find/id")
    public String findId() {
        return "login/findId";
    }

    @PostMapping("/find/id/ok")
    public boolean findIdOk() {
        return true;
    }

    @GetMapping("/find/pw")
    public String findPw() {
        return "login/findPw";
    }

    @PostMapping("/find/pw/ok")
    public boolean findPwOk() {
        return true;
    }
}
