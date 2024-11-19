package com.example.shoppingpayment.product.controller;

import com.example.shoppingpayment.common.dto.ApiResponse;
import com.example.shoppingpayment.product.dto.ProductCreateRequestDTO;
import com.example.shoppingpayment.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductCreateRequestDTO request) {
        productService.createProduct(request);
        ApiResponse response = new ApiResponse(true, 201, "상품이 성공적으로 등록되었습니다.");
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.ok(new ApiResponse(true, 200, "상품이 성공적으로 삭제되었습니다."));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, 404, e.getMessage()));
        }
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long productId, @RequestBody ProductCreateRequestDTO updateDTO){
        try {
            productService.updateProduct(productId, updateDTO);
            return ResponseEntity.ok(new ApiResponse(true, 200, "상품이 성공적으로 수정되었습니다."));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, 404, e.getMessage()));
        }

    }

}
