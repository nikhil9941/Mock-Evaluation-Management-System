package com.mockeval.repository;

import com.mockeval.entity.Rounds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoundRepo extends JpaRepository<Rounds, Integer> {

    // Get all rounds by technology
    List<Rounds> findByTechnologyTechnoId(Integer technoId);

}