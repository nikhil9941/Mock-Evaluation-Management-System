package com.mockeval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rounds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rounds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "round_id")
    private Integer roundId;

    // Many rounds → one technology
    @ManyToOne
    @JoinColumn(name = "techno_id")
    private Technology technology;

    @Column(name = "round_type", length = 100)
    private String roundType;
}