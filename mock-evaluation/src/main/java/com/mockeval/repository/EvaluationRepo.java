package com.mockeval.repository;

import com.mockeval.entity.Evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepo extends JpaRepository<Evaluation, Integer> {

    // Get evaluations by participant
    List<Evaluation> findByParticipantPartId(Integer partId);

    // Get evaluations by assignment
    List<Evaluation> findByAssignAsignId(Integer assignId);
    
    List<Evaluation> findAll();
    // Average score (Report)
    @Query("SELECT AVG(e.score) FROM Evaluation e")
    Double getAverageScore();
}