package com.mut.cycle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @PostMapping("/reply/{boardId}/{pReply}")
    public String reply(@PathVariable("boardId") Long boardId, @PathVariable("pReply") Long pReply) {
        return "redirect:/board/" + boardId;
    }

    @PostMapping("/reply/like/{replyId}")
    public String replyLike(@PathVariable("replyId") Long replyId) {
        return "redirect:/board/" + replyId;
    }

    @PostMapping("/reply/report/{replyId}")
    public String replyReport(@PathVariable("replyId") Long replyId) {
        return "redirect:/board/" + replyId;
    }

    @PostMapping("/reply/modify/{replyId}")
    public String replyModify(@PathVariable("replyId") Long replyId) {
        return "redirect:/board/" + replyId;
    }
}
