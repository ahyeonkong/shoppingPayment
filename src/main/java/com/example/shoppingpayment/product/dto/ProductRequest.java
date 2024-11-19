package com.example.shoppingpayment.product.dto;

import com.example.shoppingpayment.product.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 자동으로 생성해주는 Lombok 어노테이션
public class ProductRequest {
    private String productName;
    private Long productPrice;
    private String productDescription;
    private String productImageUrl;
    private String productCategory;

    public Product toEntity() {
        return Product.builder()
                .productName(productName)
                .productPrice(productPrice)
                .productDescription(productDescription)
                .productImageUrl(productImageUrl)
                .productCategory(productCategory)
                .build();
    }

}
