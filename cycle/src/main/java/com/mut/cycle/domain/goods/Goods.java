package com.mut.cycle.domain.goods;

import com.mut.cycle.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    private String name;
    private String info;
    private String thumbnail;
    private Double price;
    private String serviceCategory;
    private String category;
    private LocalDateTime date;
    private Integer views;
    private Integer quantity;
}