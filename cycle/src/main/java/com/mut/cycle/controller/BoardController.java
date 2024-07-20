package com.mut.cycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    @GetMapping("/board/{categoryId}/{sortId}")
    public String board(@PathVariable("categoryId") Long categoryId, @PathVariable("sortId") Long sortId) {
        return "board/board";
    }

    @PostMapping("/board/{boardId}")
    public String boardDetail(@PathVariable("boardId") Long boardId) {
        return "board/boardDetail";
    }

    @PostMapping("/board/like/{boardId}")
    public String boardLike(@PathVariable("boardId") Long boardId) {
        return "redirect:/board/" + boardId;
    }

    @PostMapping("/board/report/{boardId}")
    public String boardReport(@PathVariable("boardId") Long boardId) {
        return "redirect:/board/" + boardId;
    }

    @GetMapping("/board/write")
    public String boardWrite() {
        return "board/boardWrite";
    }

    @PostMapping("/board/write/ok")
    public String boardWriteOk() {
        return "redirect:/board";
    }

    @PostMapping("/board/modify/{boardId}")
    public String boardModify(@PathVariable("boardId") Long boardId) {
        return "board/boardModify";
    }

    @PostMapping("/board/modify/ok/{boardId}")
    public String boardModifyOk(@PathVariable("boardId") Long boardId) {
        return "redirect:/board/" + boardId;
    }

    @PostMapping("/board/search/{boardCateId}/{searchCate}/{searchContents}")
    public String boardSearch(@PathVariable("boardCateId") Long boardCateId, @PathVariable("searchCate") String searchCate, @PathVariable("searchContents") String searchContents) {
        return "board/boardSearch";
    }
}
