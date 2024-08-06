package com.mut.cycle.controller;

import com.mut.cycle.service.BoardService;
import com.mut.cycle.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    BoardService boardService;
    @Autowired
    CommentService commentService;

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
