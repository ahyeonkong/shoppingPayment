package com.example.shoppingpayment.product.service;

import com.example.shoppingpayment.product.domain.Product;
import com.example.shoppingpayment.product.dto.ProductRequest;
import com.example.shoppingpayment.product.dto.ProductResponse;
import com.example.shoppingpayment.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성
public class ProductService {
    // ProductRepository를 의존성 주입받기 위한 final 필드 선언
    private final ProductRepository productRepository;

    @Transactional
    public void createProduct(ProductRequest request){
        // Product 엔티티의 필드명과 일치하게 작성
        Product product = Product.builder()
                .productName(request.getProductName())
                .productPrice(request.getProductPrice())
                .productDescription(request.getProductDescription())
                .productImageUrl(request.getProductImageUrl())
                .productCategory(request.getProductCategory())
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Id가 "+ productId + "인 상품을 찾을 수 없습니다."));
        productRepository.delete(product);
    }

    @Transactional
    public void updateProduct(Long productId, ProductRequest updateDTO){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Id가 "+ productId + "인 상품을 찾을 수 없습니다."));

        // PATCH를 사용했기 떄문에 널이 아닌 필드만 업데이트 하는 로직이 필요함
        if (updateDTO.getProductName() != null) {
            product.setProductName(updateDTO.getProductName());
        }
        if (updateDTO.getProductPrice() != null) {
            product.setProductPrice(updateDTO.getProductPrice());
        }
        if (updateDTO.getProductDescription() != null) {
            product.setProductDescription(updateDTO.getProductDescription());
        }
        if (updateDTO.getProductImageUrl() != null) {
            product.setProductImageUrl(updateDTO.getProductImageUrl());
        }
        if (updateDTO.getProductCategory() != null) {
            product.setProductCategory(updateDTO.getProductCategory());
        }
        productRepository.save(product);
    }

    // 상품 전체 목록 조회
    @Transactional
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return products.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    public ProductResponse fromEntity(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productDescription(product.getProductDescription())
                .productImageUrl(product.getProductImageUrl())
                .productCategory(product.getProductCategory())
                .build();
    }
}
