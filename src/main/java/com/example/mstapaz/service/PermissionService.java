package com.example.mstapaz.service;

import com.example.mstapaz.model.dto.CheckPermissionDto;
import com.example.mstapaz.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;




    public boolean checkPermission(CheckPermissionDto dto){

     var userPermission=  permissionRepository.findByUserIdAndPermissionNameAndProductName(dto.getUserId(),
                dto.getPermissionName(),
                dto.getProductName());
     return userPermission.isPresent();
    }
}
