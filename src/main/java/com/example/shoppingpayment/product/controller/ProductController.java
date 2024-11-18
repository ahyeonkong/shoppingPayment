package com.example.shoppingpayment.product.controller;

import com.example.shoppingpayment.product.dto.ProductCreateRequestDTO;
import com.example.shoppingpayment.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    // 상품이 성공적으로 등록되면 201 Created 상태 코드만 반환
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequestDTO request) {
        productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
