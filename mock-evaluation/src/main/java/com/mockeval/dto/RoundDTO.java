package com.mockeval.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoundDTO {

    private Integer roundId;
    private Integer technoId;
    private String roundType;
}