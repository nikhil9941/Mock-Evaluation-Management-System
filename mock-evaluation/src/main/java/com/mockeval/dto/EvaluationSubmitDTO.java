package com.mockeval.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EvaluationSubmitDTO {
	private Integer partId;
    private Integer assignId;
    private Integer score;
    private String feedback;
}
