package com.example.mstapaz.model.request;

import com.example.mstapaz.enums.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRegisterRequest {
    private String username;
    private String password;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    private Roles role;
}
