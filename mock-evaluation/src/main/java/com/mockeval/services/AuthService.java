package com.mockeval.services;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mockeval.dto.AuthRequest;
import com.mockeval.dto.AuthResponse;
import com.mockeval.entity.User;
import com.mockeval.repository.UserRepo;
import com.mockeval.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthResponse login(AuthRequest req) {
        User user = repo.findByEmail(req.getEmail())
                .orElseThrow();

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwt.generateToken(user.getEmail());

        return new AuthResponse(
                user.getUserId(),
                token,
                user.getName(),
                user.getRole().name()
        );    
    }
    
    public AuthResponse register(AuthRequest req) {

        // 1. Validate input
        if (req.getEmail() == null || req.getPassword() == null || req.getName() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All fields are required");
        }

        // 2. Check if user exists
        if (repo.findByEmail(req.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists with this email");
        }

        // 3. Create user
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));

        // 4. Convert role string safely
        if (req.getRole() != null) {
            try {
                user.setRole(User.Role.valueOf(req.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role value");
            }
        } else {
            user.setRole(User.Role.EVALUATOR);
        }

        // 5. Save
        repo.save(user);

        // 6. Generate token
        String token = jwt.generateToken(user.getEmail());

        // 7. Return
        return new AuthResponse(
                user.getUserId(),
                token,
                user.getName(),
                user.getRole().name()
        );
    }
    
    public List<AuthResponse> getEvaluators() {

        List<User> evaluators = repo.findByRole(User.Role.EVALUATOR);

        return evaluators.stream()
                .map(user -> new AuthResponse(
                        user.getUserId(),
                        null,
                        user.getName(),
                        user.getRole().name()
                ))
                .collect(Collectors.toList());
    }
    
    public List<AuthResponse> getAllUsers() {

        List<User> users = repo.findAll();

        return users.stream()
                .map(user -> new AuthResponse(
                        user.getUserId(),
                        null, // no token needed here
                        user.getName(),
                        user.getRole().name()
                ))
                .collect(Collectors.toList());
    }
}
