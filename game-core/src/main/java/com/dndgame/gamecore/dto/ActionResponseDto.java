package com.dndgame.gamecore.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActionResponseDto {
    private String description;
    private List<ActionDto> actions;
}
