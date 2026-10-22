package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockeval.services.ReportService;
import com.mockeval.entity.Evaluation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService service;

    @GetMapping
    public List<Evaluation> all() {
        return service.getAll();
    }

    @GetMapping("/avg")
    public Double avg() {
        return service.getAverageScore();
    }
}
