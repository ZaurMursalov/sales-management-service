package com.example.mstapaz.mapper;

import com.example.mstapaz.entity.MattEntity;
import com.example.mstapaz.model.dto.MattDto;
import com.example.mstapaz.model.request.MattPriceRequest;
import com.example.mstapaz.model.request.MattRequest;

public class MattMapper {


    public static MattEntity mattToEntity(MattRequest request){
        return MattEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public static MattDto mattToDto(MattEntity mattEntity){
        return MattDto.builder()
                .id(mattEntity.getId())
                .name(mattEntity.getName())
                .price(mattEntity.getPrice())
                .build();

    }

    public static void updateMapper(MattEntity entity, MattPriceRequest price){
        entity.setPrice(price.getPrice());
    }
}
