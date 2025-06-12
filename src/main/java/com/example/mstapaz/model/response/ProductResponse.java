package com.example.mstapaz.model.response;

import com.example.mstapaz.model.request.AttributeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String title;
    private BigDecimal price;
    private String category;
    private String ownerUsername;
    private List<AttributeDTO> attributes;

}