package com.mockeval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "evaluation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eval_id")
	private Integer evalId;   

    // Many evaluations → one participant
    @ManyToOne
    @JoinColumn(name = "part_id")
    private Participant participant;

    // Many evaluations → one assignment
    @ManyToOne
    @JoinColumn(name = "assign_id")
    private EvaluatorAssign assign;

    private Integer score;

    @Column(length = 200)
    private String feedback;
}