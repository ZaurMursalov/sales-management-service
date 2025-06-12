package com.example.mstapaz.mapper;

import com.example.mstapaz.entity.ProductEntity;
import com.example.mstapaz.model.request.AttributeDTO;
import com.example.mstapaz.model.response.ProductResponse;

import java.util.List;

public class ProductMapper {

    public static ProductResponse mapToResponse(ProductEntity product) {
        List<AttributeDTO> attributes = product.getAttributes().stream().map(
                        attr -> AttributeDTO.builder().key(attr.getKey())
                                .value(attr.getValue())
                                .build())
                .toList();


        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .category(product.getCategory().getName())
                .ownerUsername(product.getOwner().getUsername())
                .attributes(attributes)
                .build();

    }


}
