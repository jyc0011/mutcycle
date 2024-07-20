package com.mut.cycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    @PostMapping("/order/{userId}/{cartId}")
    public String order(@PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId) {
        return "order/order";
    }

    @PostMapping("/order/ok/{userId}/{cartId}")
    public String orderOk(@PathVariable("userId") Long userId, @PathVariable("cartId") Long cartId) {
        return "redirect:/mypage/mybuylist/" + userId;
    }
}
