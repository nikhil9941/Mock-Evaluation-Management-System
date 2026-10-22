package com.mockeval.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "batches")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id")   // DB column
    private Integer batchId;     // ✅ Java field

    @Column(name = "batch_name", unique = true)
    private String batchName;    // ✅ Java field
}