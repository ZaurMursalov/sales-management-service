package com.example.mstapaz.service.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisTokenService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String PREFIX = "user:";

    public void saveRefreshToken(String username, String token, long duration, TimeUnit unit) {
        String key = PREFIX + username;

        redisTemplate.opsForHash().put(key, "refreshToken", token);
        redisTemplate.expire(key, duration, unit);
    }

    public String getRefreshToken(String username) {
        String key = PREFIX + username;
        Object token = redisTemplate.opsForHash().get(key, "refreshToken");
        return token != null ? token.toString() : null;
    }

    public void deleteRefreshToken(String username) {
        String key = PREFIX + username;
        redisTemplate.opsForHash().delete(key, "refreshToken");
    }

    public void saveCustomData(String username, String field, Object value) {
        redisTemplate.opsForHash().put(PREFIX + username, field, value);
    }

    public Object getCustomData(String username, String field) {
        return redisTemplate.opsForHash().get(PREFIX + username, field);
    }
}
