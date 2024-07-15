package com.mut.cycle.domain.board;

import com.mut.cycle.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String contents;
    private LocalDateTime date;
    private Integer view;
    private Boolean isDeleted;
}
