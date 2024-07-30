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
        return loginService.login(id, password)
                .map(user -> {
                    session.setAttribute("log_stat", "login");
                    session.setAttribute("id", id);
                    return "redirect:/home";
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid email or password");
                    return "login/login";
                });
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(HttpSession session) {
        if("login".equals((session.getAttribute("log_stat")))){
            return "redirect:/";
        }
        session.invalidate();
        return "login/register";
    }


    @PostMapping("/register/idcheck")
    public boolean idCheck() {
        return true;
    }

    @PostMapping("/register/emailcheck/send")
    @ResponseBody
    public Map<String, Object> emailCheckSend(@RequestParam("email") String email, HttpSession session) {

        int result = loginService.loginCheckEmail(email);
        var map = new HashMap<String, Object>();

        if(result>1){
            map.put("result", false);
            map.put("msg", "Duplicated email error");
            return map;
        }
        try {
            var authNum = emailService.sendAuthMail(email);
            session.setAttribute("authNum", authNum);
            session.setAttribute("authTime", System.currentTimeMillis());
            map.put("result", true);
            return map;
        } catch (Exception e) {
            System.out.println("error");
        }
        map.put("result", false);
        map.put("msg", "Mail service error");
        return map;
    }


    @PostMapping("/register/emailcheck/check")
    public boolean emailCheck(@RequestParam("code") String code, HttpSession session) {
        var time = (long) session.getAttribute("authTime");
        if (System.currentTimeMillis() > time + 1000 * 60 * 3) {
            session.removeAttribute("authNum");
            session.removeAttribute("authTime");
            return false;
        }
        if (!code.equals(session.getAttribute("authNum"))) {
            return false;
        }
        session.removeAttribute("authNum");
        session.removeAttribute("authTime");
        session.setAttribute("emailValid", "Y");

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
