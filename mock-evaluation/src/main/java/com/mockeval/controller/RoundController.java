package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mockeval.dto.RoundDTO;
import com.mockeval.entity.Rounds;
import com.mockeval.services.RoundService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rounds")
@RequiredArgsConstructor
public class RoundController {

    private final RoundService service;

    // ✅ Create Round
    @PostMapping
    public Rounds create(@RequestBody RoundDTO round) {
        return service.create(round);
    }

    // ✅ Get All Rounds
    @GetMapping
    public List<Rounds> getAll() {
        return service.getAll();
    }

    // ✅ Get Round by ID
    @GetMapping("/{id}")
    public Rounds getById(@PathVariable Integer id) {
        return service.getById(id);
    }
    
    @GetMapping("/technology/{techId}")
    public List<Rounds> getByTechnoId(@PathVariable Integer techId) {
        return service.getByTechnology(techId);
    }
    // ✅ Update Round
    @PutMapping("/{id}")
    public Rounds update(@PathVariable Integer id, @RequestBody RoundDTO round) {
        return service.update(id, round);
    }

    // ✅ Delete Round
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        service.delete(id);
        return "Round deleted successfully";
    }
}