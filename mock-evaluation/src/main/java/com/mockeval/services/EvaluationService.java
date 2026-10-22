package com.mockeval.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mockeval.dto.EvaluationResponseDTO;
import com.mockeval.entity.Evaluation;
import com.mockeval.entity.Participant;
import com.mockeval.entity.Technology;
import com.mockeval.repository.AssignRepo;
import com.mockeval.repository.EvaluationRepo;
import com.mockeval.repository.ParticipantRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepo repo;
    private final ParticipantRepo partRepo;
    private final AssignRepo assignRepo;

    public Evaluation submit(Integer partId, Integer assignId, Integer score, String feedback) {

        Evaluation e = new Evaluation();
        e.setParticipant(partRepo.findById(partId).orElseThrow());
        e.setAssign(assignRepo.findById(assignId).orElseThrow());
        e.setScore(score);
        e.setFeedback(feedback);

        return repo.save(e);
    }

//    public List<EvaluationResponseDTO> getAllFiltered(String batch, String technology) {
//        List<Evaluation> evaluations = repo.findAll(); // just fetch all
//        return evaluations.stream()
//                .map(e -> new EvaluationResponseDTO(
//                        e.getEvalId(),
//                        e.getParticipant().getName(),
//                        e.getParticipant().getPartId(),
//                        e.getScore()
//                   ))
//                .collect(Collectors.toList());
//    }
    
    
    public List<EvaluationResponseDTO> getAllFiltered() {
        List<Evaluation> evaluations = repo.findAll(); // fetch all evaluations

        return evaluations.stream()
                .map(e -> {
                    Participant p = e.getParticipant();
                    Technology t = p.getTechnology(); // get technology entity
                    return new EvaluationResponseDTO(
                            e.getEvalId(),              // id
                            p.getName(),                // participantName
                            p.getPartId(),              // participantId
                            e.getScore(),               // score
                            t != null ? t.getTechnology() : null // technology
                    );
                })
                .collect(Collectors.toList());
    }
}
