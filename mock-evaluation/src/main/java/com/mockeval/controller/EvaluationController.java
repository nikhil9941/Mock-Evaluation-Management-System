package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockeval.dto.EvaluationResponseDTO;
import com.mockeval.dto.EvaluationSubmitDTO;
import com.mockeval.entity.Evaluation;
import com.mockeval.services.EvaluationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/evaluations")
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService service;

    @PostMapping("/submit")
    public Evaluation submit(@RequestBody EvaluationSubmitDTO dto) {
        return service.submit(dto.getPartId(), dto.getAssignId(), dto.getScore(), dto.getFeedback());
    }

    @GetMapping
    public List<EvaluationResponseDTO> getAll() {
        return service.getAllFiltered();
    }
}