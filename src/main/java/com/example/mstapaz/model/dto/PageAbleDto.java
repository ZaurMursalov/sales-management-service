package com.example.mstapaz.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PageAbleDto {

    List<MattDto>mattress;

    Long totalElements;

    int totalPages;

    boolean hasNExtPages;
}
