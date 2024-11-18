package com.example.shoppingpayment.product.repository;

import com.example.shoppingpayment.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
