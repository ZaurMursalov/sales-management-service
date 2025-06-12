package com.example.mstapaz.controller;

import com.example.mstapaz.model.request.UserLoginRequest;
import com.example.mstapaz.model.request.UserRegisterRequest;
import com.example.mstapaz.security.JwtResponse;
import com.example.mstapaz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRegisterRequest request) {
        userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
