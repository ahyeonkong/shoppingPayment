package com.example.shoppingpayment.orders.domain;

import com.example.shoppingpayment.users.domain.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "orders")  // "order"는 SQL 예약어이므로 "orders"로 테이블 이름 지정
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id", nullable = false)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @Column(name = "orders_total_price", nullable = false)
    private Long orderTotalPrice;

    @Column(name = "orders_status", nullable = false, length = 20)
    private String orderStatus;

    @CreationTimestamp
    @Column(name = "orders_created_at", nullable = false, updatable = false)
    private LocalDateTime orderCreatedAt;

    @UpdateTimestamp
    @Column(name = "orders_updated_at")
    private LocalDateTime orderUpdatedAt;

}