package com.mut.cycle.controller;

import com.mut.cycle.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MypageController {
    @Autowired
    MypageService mypageService;

    @GetMapping("/mypage/info/{userId}")
    public String info(@PathVariable("userId") Long userId) {
        return "mypage/info";
    }

    @PostMapping("/mypage/info/change/{userId}")
    public String infoChange(@PathVariable("userId") Long userId) {
        return "redirect:/mypage/info/" + userId;
    }

    @GetMapping("/mypage/mygoods/{userId}")
    public String myGoods(@PathVariable("userId") Long userId) {
        return "mypage/myGoods";
    }

    @GetMapping("/mypage/mybuylist/{userId}")
    public String myBuyList(@PathVariable("userId") Long userId) {
        return "mypage/myBuyList";
    }

    @PostMapping("/mypage/mybuylist/{userId}/{orderId}")
    public String myBuyDetail(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) {
        return "mypage/myBuyDetail";
    }

    @PostMapping("/mypage/mybuylist/delete/{userId}")
    public String deleteBuy(@PathVariable("userId") Long userId) {
        return "redirect:/mypage/mybuylist/" + userId;
    }

    @GetMapping("/mypage/myselllist/{userId}")
    public String mySellList(@PathVariable("userId") Long userId) {
        return "mypage/mySellList";
    }

    @PostMapping("/mypage/myselllist/{userId}/{orderId}")
    public String mySellDetail(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId) {
        return "mypage/mySellDetail";
    }

    @PostMapping("/mypage/myselllist/delete/{userId}")
    public String deleteSell(@PathVariable("userId") Long userId) {
        return "redirect:/mypage/myselllist/" + userId;
    }

    @GetMapping("/mypage/board/{userId}")
    public String myBoard(@PathVariable("userId") Long userId) {
        return "mypage/myBoard";
    }

    @GetMapping("/mypage/comment/{userId}")
    public String myComment(@PathVariable("userId") Long userId) {
        return "mypage/myComment";
    }
}