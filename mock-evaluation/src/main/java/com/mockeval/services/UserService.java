package com.mockeval.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mockeval.entity.User;
import com.mockeval.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;
    private final PasswordEncoder encoder;

    public List<User> getAll() {
        return repo.findAll();
    }

    public User save(User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return repo.save(u);
    }
}