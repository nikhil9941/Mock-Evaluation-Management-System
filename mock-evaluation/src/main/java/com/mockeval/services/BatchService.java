package com.mockeval.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockeval.entity.Batch;
import com.mockeval.repository.BatchRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {

    private final BatchRepo repo;

    public List<Batch> getAll() {
        return repo.findAll();
    }

    public Batch save(Batch b) {
        return repo.save(b);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}