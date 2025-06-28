package com.example.mstapaz.controller;

import com.example.mstapaz.model.request.RefreshTokenRequest;
import com.example.mstapaz.model.request.UserLoginRequest;
import com.example.mstapaz.model.request.UserRegisterRequest;
import com.example.mstapaz.security.JwtResponse;
import com.example.mstapaz.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "İstifadəçi qeydiyyatı, giriş və token yenilənməsi əməliyyatları")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Qeydiyyatdan keç", description = "Yeni istifadəçi qeydiyyatı")
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Qeydiyyat məlumatları")
            @RequestBody UserRegisterRequest request) {
        userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Giriş et", description = "İstifadəçi sistemə daxil olur və access + refresh token alır")
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Login məlumatları")
            @RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @Operation(summary = "Token yenilə", description = "Refresh token vasitəsilə yeni access token al")
    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refresh(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Refresh token məlumatı")
            @RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(userService.refreshAccessToken(request.getRefreshToken()));
    }
}