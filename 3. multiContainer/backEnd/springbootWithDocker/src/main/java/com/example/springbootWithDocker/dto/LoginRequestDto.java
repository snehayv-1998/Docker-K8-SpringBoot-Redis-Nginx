package com.example.springbootWithDocker.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String name;
    private String email;
    private String password;
}
