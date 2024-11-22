package com.example.mstapaz.controller;

import com.example.mstapaz.model.dto.CheckPermissionDto;
import com.example.mstapaz.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v3/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/check")
    public boolean checkPermission(@RequestBody CheckPermissionDto permissionDto){

        return permissionService.checkPermission(permissionDto);

    }

}
