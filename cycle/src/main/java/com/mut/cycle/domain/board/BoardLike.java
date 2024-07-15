package com.mut.cycle.domain.board;

import com.mut.cycle.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class BoardLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
