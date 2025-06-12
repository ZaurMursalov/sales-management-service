package com.example.mstapaz.service.impl;

import com.example.mstapaz.entity.UserEntity;
import com.example.mstapaz.model.request.UserLoginRequest;
import com.example.mstapaz.model.request.UserRegisterRequest;
import com.example.mstapaz.repository.UserRepository;
import com.example.mstapaz.security.JwtResponse;
import com.example.mstapaz.security.JwtService;
import com.example.mstapaz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public void register(UserRegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        UserEntity user = UserEntity.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(request.getRole())
                .build();

        userRepository.save(user);
    }

    @Override
    public JwtResponse login(UserLoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(user);
        return new JwtResponse(token);
    }
}
