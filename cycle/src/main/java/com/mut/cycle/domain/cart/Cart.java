package com.mut.cycle.domain.cart;

import com.mut.cycle.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double price;

    @OneToMany(mappedBy = "cart")
    private List<CartDetail> cartDetails;
}
