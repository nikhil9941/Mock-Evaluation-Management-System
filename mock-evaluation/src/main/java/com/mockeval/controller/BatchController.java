package com.mockeval.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mockeval.dto.BatchDTO;
import com.mockeval.entity.Batch;
import com.mockeval.services.BatchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/batches")
@RequiredArgsConstructor
public class BatchController {

    private final BatchService service;

    @GetMapping
    public List<Batch> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Batch create(@RequestBody BatchDTO dto) {
        Batch b = new Batch();
        b.setBatchName(dto.getBatchName());
        return service.save(b);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
