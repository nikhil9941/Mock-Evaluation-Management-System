package com.mockeval.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockeval.entity.EvaluatorAssign;
import com.mockeval.repository.AssignRepo;
import com.mockeval.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignRepo repo;
    private final UserRepo userRepo;

    public EvaluatorAssign assign(Integer userId, Integer roundId) {
        EvaluatorAssign a = new EvaluatorAssign();
        a.setUser(userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")));
        a.setRoundId(roundId); 
        return repo.save(a);
    }
    
    public void deleteById(Integer assignId) {
        if (!repo.existsById(assignId)) {
            throw new RuntimeException("Assignment not found with id: " + assignId);
        }
        repo.deleteById(assignId);
    }

    public List<EvaluatorAssign> getAll() {
        return repo.findAll();
    }
    
//    public List<EvaluatorAssign> getByRoundId(Integer roundId) {
//        return repo.findByRoundId(roundId)
//                .orElseThrow(() -> new RuntimeException("Assignment not found for roundId: " + roundId));
//    }
    
    public List<EvaluatorAssign> getByRoundId(Integer roundId) {
        List<EvaluatorAssign> list = repo.findByRoundId(roundId);

        if (list.isEmpty()) {
            throw new RuntimeException("No assignments found for roundId: " + roundId);
        }

        return list;
    }
    
    
}