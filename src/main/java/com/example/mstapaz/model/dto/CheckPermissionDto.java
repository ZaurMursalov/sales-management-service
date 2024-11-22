package com.example.mstapaz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckPermissionDto {

    private String userId;

    private String productName;

    private String permissionName;

}
