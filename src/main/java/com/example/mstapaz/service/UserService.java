package com.example.mstapaz.service;

import com.example.mstapaz.model.request.UserLoginRequest;
import com.example.mstapaz.model.request.UserRegisterRequest;
import com.example.mstapaz.security.JwtResponse;

public interface UserService {
    void register(UserRegisterRequest request);
    JwtResponse login(UserLoginRequest request);
}

