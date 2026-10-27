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
    private Race race;
    private int level;
    private String currentLocationId;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private int hp;
    private int maxHp;

    public int getStrModifier() { return (strength - 10) / 2; }
    public int getDexModifier() { return (dexterity - 10) / 2; }
    public int getConModifier() { return (constitution- 10) / 2; }
    public int getIntModifier() { return (intelligence- 10) / 2; }
    public int getWisModifier() { return (wisdom - 10) / 2; }
    public int getChaModifier() { return (charisma - 10) / 2; }
}