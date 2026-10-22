package com.mockeval.repository;

import com.mockeval.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant, Integer> {

    // Get participants by batch
    List<Participant> findByBatchBatchId(Integer batchId);

    // Get participants by technology
    List<Participant> findByTechnologyTechnoId(Integer technoId);

}