package com.mut.cycle.domain.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity @Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String nick;
    private LocalDateTime birth;
    private String profileImg;
    private String bio;
}