package com.mockeval.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "technologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "techno_id")   // DB column
    private Integer technoId;     // Java field (camelCase ✅)


    @Column(unique = true)
    private String technology;
}