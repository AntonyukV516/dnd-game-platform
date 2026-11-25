package com.dndgame.gamecore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CombatState {
    private String partyId;
    private List<Player> turnOrder;
    private int currentTurnIndex;
    private int round;
    private String locationId;
}
