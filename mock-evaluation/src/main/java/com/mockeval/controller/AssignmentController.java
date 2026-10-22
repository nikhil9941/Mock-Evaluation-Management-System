package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mockeval.dto.AssignRequest;
import com.mockeval.entity.EvaluatorAssign;
import com.mockeval.services.AssignmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService service;

    // ✅ Assign evaluator to a round
    @PostMapping
    public EvaluatorAssign assign(@RequestBody AssignRequest req) {
        return service.assign(req.getUserId(), req.getRoundId());
    }

    // ✅ Get all assignments
    @GetMapping
    public List<EvaluatorAssign> getAll() {
        return service.getAll();
    }
    
    @DeleteMapping("/{assignId}")
    public String delete(@PathVariable Integer assignId) {
        service.deleteById(assignId);
        return "Assignment deleted successfully";
    }
    
//    @GetMapping("/{roundId}")
//    public EvaluatorAssign getById(@PathVariable Integer roundId) {
//    	return service.getByRoundId(roundId);
//    }
    
    @GetMapping("/{roundId}")
    public List<EvaluatorAssign> getById(@PathVariable Integer roundId) {
        return service.getByRoundId(roundId);
    }
}