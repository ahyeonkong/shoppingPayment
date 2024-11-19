package com.example.shoppingpayment.product.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {
    private Long productId;
    private String productName;
    private Long productPrice;
    private String productDescription;
    private String productImageUrl;
    private String productCategory;
}
