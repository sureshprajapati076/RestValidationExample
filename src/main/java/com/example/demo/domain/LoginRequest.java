package com.example.demo.domain;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
}
