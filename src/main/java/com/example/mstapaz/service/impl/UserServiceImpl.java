package com.example.mstapaz.service.impl;

import com.example.mstapaz.entity.UserEntity;
import com.example.mstapaz.model.request.UserLoginRequest;
import com.example.mstapaz.model.request.UserRegisterRequest;
import com.example.mstapaz.repository.UserRepository;
import com.example.mstapaz.security.JwtResponse;
import com.example.mstapaz.security.JwtService;
import com.example.mstapaz.service.UserService;
import com.example.mstapaz.service.redis.RedisTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RedisTokenService refreshTokenService;

    @Override
    public void register(UserRegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username is already in use");
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
        UserEntity user = getUserByUsername(request.getUsername());

        validatePassword(request.getPassword(), user.getPassword());

        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        refreshTokenService.saveRefreshToken(user.getUsername(), refreshToken, 7, TimeUnit.DAYS);

        return new JwtResponse(accessToken, refreshToken);
    }

    @Override
    public JwtResponse refreshAccessToken(String refreshToken) {
        if (!jwtService.isValid(refreshToken)) {
            throw new BadCredentialsException("Refresh token is invalid or expired");
        }

        String username = jwtService.extractUsername(refreshToken);

        String savedToken = refreshTokenService.getRefreshToken(username);

        if (savedToken == null || !savedToken.equals(refreshToken)) {
            throw new BadCredentialsException("Refresh token mismatch or not found");
        }

        UserEntity user = getUserByUsername(username);

        String newAccessToken = jwtService.generateAccessToken(user);

        return new JwtResponse(newAccessToken, refreshToken);
    }


    private UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    private void validatePassword(String rawPassword, String encodedPassword) {
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            throw new BadCredentialsException("Invalid password");
        }
    }
}
