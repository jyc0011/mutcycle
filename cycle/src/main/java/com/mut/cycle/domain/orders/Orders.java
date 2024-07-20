package com.mut.cycle.domain.orders;

import com.mut.cycle.domain.enums.OrdersConditions;
import com.mut.cycle.domain.user.Address;
import com.mut.cycle.domain.user.User;
import com.mut.cycle.domain.goods.Goods;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "goods_id")
    private Goods goods;

    private Double price;
    private LocalDateTime date;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private OrdersConditions conditions;
}