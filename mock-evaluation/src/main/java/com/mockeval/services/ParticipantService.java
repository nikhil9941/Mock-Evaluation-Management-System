package com.mockeval.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockeval.dto.ParticipantRequest;
import com.mockeval.entity.Participant;
import com.mockeval.repository.BatchRepo;
import com.mockeval.repository.ParticipantRepo;
import com.mockeval.repository.TechnologyRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ParticipantRepo repo;
    private final BatchRepo batchRepo;
    private final TechnologyRepo techRepo;

    public Participant create(ParticipantRequest req) {
        Participant p = new Participant();
        p.setName(req.getName());
        p.setEmail(req.getEmail());

        p.setBatch(batchRepo.findById(req.getBatchId()).orElseThrow());
        p.setTechnology(techRepo.findById(req.getTechnoId()).orElseThrow());

        return repo.save(p);
    }

    public List<Participant> getAll() {
        return repo.findAll();
    }
}
