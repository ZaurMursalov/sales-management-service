package com.example.mstapaz.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MattressDetailsRequest {
    private LocalDateTime createdOn;
    private String createdBy;
}
