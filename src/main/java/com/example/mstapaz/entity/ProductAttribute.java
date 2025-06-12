package com.example.mstapaz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_attributes")
@Data
public class ProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String value;

    @ManyToOne
    private ProductEntity product;
}
