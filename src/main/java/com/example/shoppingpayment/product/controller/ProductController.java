package com.example.shoppingpayment.product.controller;

import com.example.shoppingpayment.common.dto.ApiResponse;
import com.example.shoppingpayment.common.dto.GenericApiResponse;
import com.example.shoppingpayment.product.dto.ProductRequest;
import com.example.shoppingpayment.product.dto.ProductResponse;
import com.example.shoppingpayment.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductRequest request) {
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
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long productId, @RequestBody ProductRequest updateDTO){
        try {
            productService.updateProduct(productId, updateDTO);
            return ResponseEntity.ok(new ApiResponse(true, 200, "상품이 성공적으로 수정되었습니다."));
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, 404, e.getMessage()));
        }

    }

    // 전체 목록 조회는 GenericApiResponse로 묶고, List로 묶어서 반환
    @GetMapping
    public ResponseEntity<GenericApiResponse<List<ProductResponse>>> getAllProducts(){
        try{
            List<ProductResponse> products = productService.getAllProducts();
            GenericApiResponse<List<ProductResponse>> response = new GenericApiResponse<>(true, 200, "상품 목록을 성공적으로 조회했습니다.", products);
            return ResponseEntity.ok(response);
        }catch (EntityNotFoundException e) {
            GenericApiResponse<List<ProductResponse>> response = new GenericApiResponse<>(false, 404, "상품 목록이 없습니다.", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    // 상세 목록 조회
    @GetMapping("/{productId}")
    public ResponseEntity<GenericApiResponse<ProductResponse>> getProductById(@PathVariable Long productId) {
        try {
            ProductResponse product = productService.getOneProduct(productId);
            GenericApiResponse<ProductResponse> response = new GenericApiResponse<>(true, 200, "상품을 성공적으로 조회했습니다.", product);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e) {
            GenericApiResponse<ProductResponse> response = new GenericApiResponse<>(false, 404, "상품 목록이 없습니다.", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
