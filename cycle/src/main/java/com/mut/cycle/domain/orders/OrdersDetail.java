package com.mut.cycle.domain.orders;

import com.mut.cycle.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private Integer quantity;
}