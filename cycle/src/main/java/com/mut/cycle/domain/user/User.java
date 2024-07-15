package com.mut.cycle.domain.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity @Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    @Embedded
    private Address address;

    private LocalDateTime signupDate;
    private LocalDateTime accessDate;

    @OneToMany(mappedBy = "user")
    private List<UserProfile> profiles;
}
