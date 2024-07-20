package com.mut.cycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsedGoodsController {

    @GetMapping("/used/goods/{sortId}")
    public String goods(@PathVariable("sortId") Long sortId) {
        return "usedgoods/goods";
    }

    @PostMapping("/used/goods/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") Long goodsId) {
        return "usedgoods/goodsDetail";
    }

    @PostMapping("/used/goods/like/{goodsId}")
    public String goodsLike(@PathVariable("goodsId") Long goodsId) {
        return "redirect:/used/goods/" + goodsId;
    }

    @PostMapping("/used/goods/report/{goodsId}")
    public String goodsReport(@PathVariable("goodsId") Long goodsId) {
        return "redirect:/used/goods/" + goodsId;
    }

    @GetMapping("/used/goods/write")
    public String goodsWrite() {
        return "usedgoods/goodsWrite";
    }

    @PostMapping("/used/goods/write/ok")
    public String goodsWriteOk() {
        return "redirect:/used/goods";
    }

    @PostMapping("/used/goods/modify/{goodsId}")
    public String goodsModify(@PathVariable("goodsId") Long goodsId) {
        return "usedgoods/goodsModify";
    }

    @PostMapping("/used/goods/modify/ok/{goodsId}")
    public String goodsModifyOk(@PathVariable("goodsId") Long goodsId) {
        return "redirect:/used/goods/" + goodsId;
    }

    @PostMapping("/used/goods/search/{searchCate}/{searchContents}")
    public String goodsSearch(@PathVariable("searchCate") String searchCate, @PathVariable("searchContents") String searchContents) {
        return "usedgoods/goodsSearch";
    }

    @PostMapping("/used/goods/incart/{userId}/{goodsId}")
    public String goodsInCart(@PathVariable("userId") Long userId, @PathVariable("goodsId") Long goodsId) {
        return "redirect:/cart/" + userId;
    }
}
