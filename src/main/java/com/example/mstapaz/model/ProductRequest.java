package com.example.mstapaz.model;

import com.example.mstapaz.model.request.AttributeDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private List<AttributeDTO> attributes;
}