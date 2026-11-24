package com.dndgame.gamecore.service.monster;

import com.dndgame.gamecore.model.MonsterType;
import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShadowFactory implements MonsterFactory {
    @Override
    public MonsterType getType() {
        return MonsterType.SHADOW;
    }

    @Override
    public Player create() {
        return Player.builder()
                .id(UUID.randomUUID().toString())
                .name("Тень")
                .strength(6)
                .dexterity(14)
                .constitution(13)
                .intelligence(6)
                .wisdom(10)
                .charisma(8)
                .hp(16)
                .maxHp(16)
                .level(1)
                .build();
    }
}