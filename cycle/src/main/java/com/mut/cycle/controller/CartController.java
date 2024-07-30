package com.mut.cycle.controller;

import com.mut.cycle.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/cart/{userId}")
    public String cart(@PathVariable("userId") Long userId) {
        return "cart/cart";
    }

    @GetMapping("/cart")
    public String cart_() {
        return "cart/cart";
    }

    @PostMapping("/cart/modify/{userId}/{goodsId}")
    public String cartModify(@PathVariable("userId") Long userId, @PathVariable("goodsId") Long goodsId) {
        return "redirect:/cart/" + userId;
    }

    @PostMapping("/cart/delete/{userId}/{goodsId}")
    public String cartDelete(@PathVariable("userId") Long userId, @PathVariable("goodsId") Long goodsId) {
        return "redirect:/cart/" + userId;
    }

    @PostMapping("/cart/delete/all/{userId}/{goodsId}")
    public String cartDeleteAll(@PathVariable("userId") Long userId, @PathVariable("goodsId") Long goodsId) {

        return "redirect:/cart/" + userId;
    }
}
