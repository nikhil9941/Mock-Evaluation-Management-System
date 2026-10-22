package com.mockeval.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockeval.entity.Technology;
import com.mockeval.repository.TechnologyRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TechnologyService {

    private final TechnologyRepo repo;

    public List<Technology> getAll() {
        return repo.findAll();
    }

    public Technology save(Technology t) {
        return repo.save(t);
    }
    
    public Technology getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Technology not found with id: " + id));
    }
}