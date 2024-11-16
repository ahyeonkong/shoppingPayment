package com.example.shoppingpayment.cart.domain;

import com.example.shoppingpayment.cartItem.domain.CartItem;
import com.example.shoppingpayment.users.domain.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false, unique = true)
    private Users users;

    @Column(name = "cart_total_price", nullable = false)
    private Long cartTotalPrice;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();
}
