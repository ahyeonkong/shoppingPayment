package com.example.shoppingpayment.payment.domain;

import com.example.shoppingpayment.orders.domain.Orders;
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
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;

    @Column(name = "payment_price", nullable = false)
    private Long paymentPrice;

    @Column(name = "payment_status", nullable = false, length = 20)
    private String paymentStatus;

    @Column(name = "payment_method", nullable = false, length = 20)
    private String paymentMethod;

    @Column(name = "transaction_id", nullable = false, length = 50)
    private String transactionId;

    @CreationTimestamp
    @Column(name = "payment_created_at", nullable = false, updatable = false)
    private LocalDateTime paymentCreatedAt;

    @UpdateTimestamp
    @Column(name = "payment_updated_at")
    private LocalDateTime paymentUpdatedAt;
}
