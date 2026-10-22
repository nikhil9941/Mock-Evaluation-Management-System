package com.mockeval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evaluator_asign")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluatorAssign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asign_id")   // DB column
    private Integer asignId;     // ✅ Java field

    @Column(name = "round_id")
    private Integer roundId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}