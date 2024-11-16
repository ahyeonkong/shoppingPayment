package com.example.shoppingpayment.cartItem.domain;

import com.example.shoppingpayment.cart.domain.Cart;
import com.example.shoppingpayment.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 기능
    @Column(name = "cart_item_id", nullable = false)
    private Long cartItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "cart_item_quantity", nullable = false)
    private Integer cartItemQuantity;

    @Column(name = "cart_item_price", nullable = false)
    private Long cartItemPrice;

    @Column(name = "cart_item_total_price", nullable = false)
    private Long cartItemTotalPrice;
}
