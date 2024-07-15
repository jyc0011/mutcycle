package com.mut.cycle.domain.cart;

import com.mut.cycle.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private Integer quantity;
}
