package com.mockeval.repository;

import com.mockeval.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch, Integer> {

}