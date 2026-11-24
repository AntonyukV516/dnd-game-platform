package com.dndgame.gamecore.service.monster;

import com.dndgame.gamecore.model.MonsterType;
import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ImpFactory implements MonsterFactory {
    @Override
    public MonsterType getType() {
        return MonsterType.IMP;
    }

    @Override
    public Player create() {
        return Player.builder()
                .id(UUID.randomUUID().toString())
                .name("Бес")
                .strength(6)
                .dexterity(17)
                .constitution(13)
                .intelligence(11)
                .wisdom(12)
                .charisma(14)
                .hp(10)
                .maxHp(10)
                .level(1)
                .build();
    }
}
