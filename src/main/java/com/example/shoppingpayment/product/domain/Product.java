package com.example.shoppingpayment.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long product_id;
    @Column
    String product_name;
    @Column
    Long product_price;
    @Column
    String product_description;
    @Column
    String product_image_url;
    @Column
    String product_category;
    @Column
    LocalDate product_created_at;
    @Column
    LocalDate product_updated_at;


}
