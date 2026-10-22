package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockeval.dto.AuthRequest;
import com.mockeval.dto.AuthResponse;
import com.mockeval.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    
    @GetMapping("/users")
    public List<AuthResponse> getAll(){
    	return service.getAllUsers();
    }
    
    @GetMapping("/evaluators")
    public List<AuthResponse> getEvaluator() {
        return service.getEvaluators();
    }
    
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        return service.login(req);
    }
    
    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest req) {
        return service.register(req);
    }
    
}