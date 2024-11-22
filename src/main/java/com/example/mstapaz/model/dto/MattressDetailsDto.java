package com.example.mstapaz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MattressDetailsDto {
    private LocalDateTime createdOn;
    private String createdBy;
}
