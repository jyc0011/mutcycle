package com.mut.cycle.domain.goods;

import com.mut.cycle.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
@Entity @Data
public class GoodsLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;
}