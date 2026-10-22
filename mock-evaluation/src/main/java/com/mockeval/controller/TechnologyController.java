package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.mockeval.entity.Technology;
import com.mockeval.services.TechnologyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService service;

    // ✅ Get all technologies
    @GetMapping
    public List<Technology> getAll() {
        return service.getAll();
    }
    
    @GetMapping("{id}")
    public Technology getById(@PathVariable Integer id) {
    	return service.getById(id);
    }

    // ✅ Create new technology
    @PostMapping
    public Technology create(@RequestBody Technology technology) {
        return service.save(technology);
    }
}