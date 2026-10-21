package com.dndgame.gamecore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private String id;
    private String name;
    private CharacterClass characterClass;
    private Origin origin;
    private String race;
    private int hp;
    private int level;
    private String currentLocationId;
}