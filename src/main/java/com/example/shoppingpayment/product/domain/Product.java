package com.example.shoppingpayment.product.domain;

import com.example.shoppingpayment.cartItem.domain.CartItem;
import com.example.shoppingpayment.orderItem.domain.OrderItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private Long productPrice;

    @Column(name = "product_description", length = 50)
    private String productDescription;

    @Column(name = "product_image_url", length = 255)
    private String productImageUrl;

    @Column(name = "product_category", nullable = false, length = 50)
    private String productCategory;

    @CreationTimestamp
    @Column(name = "product_created_at", nullable = false, updatable = false)
    private LocalDateTime productCreatedAt;

    @UpdateTimestamp
    @Column(name = "product_updated_at")
    private LocalDateTime productUpdatedAt;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems = new ArrayList<>();
}
