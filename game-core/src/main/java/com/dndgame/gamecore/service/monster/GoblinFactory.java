package com.dndgame.gamecore.service.monster;

import com.dndgame.gamecore.model.MonsterType;
import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GoblinFactory implements MonsterFactory {

    @Override
    public MonsterType getType() {
        return MonsterType.GOBLIN;
    }

    @Override
    public Player create() {
        return Player.builder()
                .id(UUID.randomUUID().toString())
                .name("Гоблин")
                .strength(8)
                .dexterity(14)
                .constitution(10)
                .intelligence(10)
                .wisdom(8)
                .charisma(8)
                .hp(7)
                .maxHp(7)
                .level(1)
                .build();
    }
}
