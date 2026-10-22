package com.mockeval.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignRequest {
	private Integer roundId;
    private Integer userId;
}
