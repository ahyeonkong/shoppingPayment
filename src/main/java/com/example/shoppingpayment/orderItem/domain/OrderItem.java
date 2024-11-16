package com.example.shoppingpayment.orderItem.domain;

import com.example.shoppingpayment.orders.domain.Orders;
import com.example.shoppingpayment.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "order_item_quantity", nullable = false)
    private Integer orderItemQuantity;

    @Column(name = "order_item_price", nullable = false)
    private Long orderItemPrice;

    @Column(name = "order_item_total_price", nullable = false)
    private Long orderItemTotalPrice;
}
