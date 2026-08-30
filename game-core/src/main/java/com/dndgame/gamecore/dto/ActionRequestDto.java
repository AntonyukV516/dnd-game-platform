package com.dndgame.gamecore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActionRequestDto {
    @NotBlank
    private String playerId;
    private String actionId;
}
