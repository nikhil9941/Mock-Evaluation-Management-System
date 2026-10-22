package com.mockeval.repository;

import com.mockeval.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepo extends JpaRepository<Technology, Integer> {

}