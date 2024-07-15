package com.mut.cycle.domain.reply;

import com.mut.cycle.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class ReplyLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply reply;
}