package com.mockeval.dto;
import com.mockeval.entity.User.Role;

import lombok.Data;

@Data
public class AuthRequest {

    private String name;      // for register
    private String email;
    private String password;

    private String role;        // optional (can be removed for security)
}