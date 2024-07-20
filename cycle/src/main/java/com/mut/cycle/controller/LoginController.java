package com.mut.cycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }
    @PostMapping("/login/check")
    public String loginCheck() {
        // 로그인 로직
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register() {
        return "login/register";
    }


    @PostMapping("/register/idcheck")
    public boolean idCheck() {
        return true;
    }

    @PostMapping("/register/emailcheck/send")
    public String emailCheckSend() {
        return "register";
    }

    @PostMapping("/register/emailcheck/check")
    public boolean emailCheck() {
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
