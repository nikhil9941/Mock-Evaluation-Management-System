package com.mockeval.repository;

import com.mockeval.entity.EvaluatorAssign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssignRepo extends JpaRepository<EvaluatorAssign, Integer> {

    // Get assignments by evaluator (user)
    List<EvaluatorAssign> findByUserUserId(Integer userId);
    //Optional<EvaluatorAssign> findByRoundId(Integer roundId);
    List<EvaluatorAssign> findByRoundId(Integer roundId);
}