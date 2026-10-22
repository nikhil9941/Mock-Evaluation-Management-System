package com.mockeval.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipantRequest {
    private String name;
    private String email;
    private Integer batchId;
    private Integer technoId;
}