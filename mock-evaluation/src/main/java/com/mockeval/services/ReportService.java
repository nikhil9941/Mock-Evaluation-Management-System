package com.mockeval.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockeval.entity.Evaluation;
import com.mockeval.repository.EvaluationRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final EvaluationRepo repo;

    public List<Evaluation> getAll() {
        return repo.findAll();
    }

    public Double getAverageScore() {
        return repo.findAll()
                .stream()
                .mapToInt(Evaluation::getScore)
                .average()
                .orElse(0.0);
    }
}