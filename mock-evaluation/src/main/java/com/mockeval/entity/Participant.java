package com.mockeval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "participants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "part_id")   // DB column stays same
	private Integer partId;     // Java field MUST be camelCase

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // Many participants belong to one batch
    @ManyToOne
    @JoinColumn(name = "batch_id")
    private Batch batch;

    // Many participants belong to one technology
    @ManyToOne
    @JoinColumn(name = "techno_id")
    private Technology technology;
}