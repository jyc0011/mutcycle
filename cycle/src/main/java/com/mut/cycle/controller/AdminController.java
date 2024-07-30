package com.mut.cycle.controller;

import com.mut.cycle.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

}
