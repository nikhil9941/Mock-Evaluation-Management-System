package com.mockeval.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.mockeval.dto.RoundDTO;
import com.mockeval.entity.Rounds;
import com.mockeval.repository.RoundRepo;
import com.mockeval.repository.TechnologyRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepo roundRepo;
    private final TechnologyRepo technologyRepo;

    // ✅ Create Round
    public Rounds create(RoundDTO dto) {
        Rounds round = new Rounds();
        round.setRoundType(dto.getRoundType());

        round.setTechnology(
            technologyRepo.findById(dto.getTechnoId()).orElseThrow()
        );

        return roundRepo.save(round);
    }

    // ✅ Get All Rounds
    public List<Rounds> getAll() {
        return roundRepo.findAll();
    }

    // ✅ Get Round by ID
    public Rounds getById(Integer id) {
        return roundRepo.findById(id).orElseThrow();
    }
    

    // ✅ Get Rounds by Technology
    public List<Rounds> getByTechnology(Integer technoId) {
        return roundRepo.findByTechnologyTechnoId(technoId);
    }

    // ✅ Update Round
    public Rounds update(Integer id, RoundDTO dto) {
        Rounds round = roundRepo.findById(id).orElseThrow();

        round.setRoundType(dto.getRoundType());

        if (dto.getTechnoId() != null) {
            round.setTechnology(
                technologyRepo.findById(dto.getTechnoId()).orElseThrow()
            );
        }

        return roundRepo.save(round);
    }

    // ✅ Delete Round
    public void delete(Integer id) {
        roundRepo.deleteById(id);
    }
}