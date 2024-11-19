package com.example.shoppingpayment.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 상품 전체 목록 조회 시 List로 묶어 ApiResponse를 반환하기 위함
@Getter
@AllArgsConstructor
public class GenericApiResponse<T> {
    private boolean isSuccess;
    private int code;
    private String message;
    private T data;
}

