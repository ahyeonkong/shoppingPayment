package com.example.shoppingpayment.product.service;

import com.example.shoppingpayment.product.domain.Product;
import com.example.shoppingpayment.product.dto.ProductCreateRequestDTO;
import com.example.shoppingpayment.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final 필드에 대한 생성자를 자동으로 생성
public class ProductService {
    // ProductRepository를 의존성 주입받기 위한 final 필드 선언
    private final ProductRepository productRepository;

    public void createProduct(ProductCreateRequestDTO request){
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
}
