package com.mockeval.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mockeval.dto.ParticipantRequest;
import com.mockeval.entity.Participant;
import com.mockeval.services.ParticipantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService service;

    @GetMapping
    public List<Participant> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Participant create(@RequestBody ParticipantRequest req) {
        return service.create(req);
    }
}