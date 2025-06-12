package com.example.mstapaz.model.request;

import com.example.mstapaz.enums.Roles;
import lombok.Data;

@Data
public class UserRegisterRequest {
    private String username;
    private String password;
    private String phoneNumber;
    private Roles role;
}
