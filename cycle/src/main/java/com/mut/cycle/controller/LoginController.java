package com.mut.cycle.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "home/home";
    }

    @GetMapping("/register")
    public String register() {
        return "login/register";
    }

    @GetMapping("/find/id")
    public String findId() {
        return "login/findId";
    }

    @GetMapping("/find/pw")
    public String findPw() {
        return "login/findPw";
    }
}
