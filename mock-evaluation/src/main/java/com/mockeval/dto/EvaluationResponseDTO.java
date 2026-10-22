package com.mockeval.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EvaluationResponseDTO {

    private Integer id;
    private String participantName;
    private Integer participantId;
    private Integer score;
    private String technology;
}
