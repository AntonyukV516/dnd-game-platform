package com.dndgame.gamecore.service.monster;

import com.dndgame.gamecore.model.MonsterType;
import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BanditFactory implements MonsterFactory {
    @Override
    public MonsterType getType() {
        return MonsterType.BANDIT;
    }

    @Override
    public Player create() {
        return Player.builder()
                .id(UUID.randomUUID().toString())
                .name("Бандит")
                .strength(11)
                .dexterity(12)
                .constitution(12)
                .intelligence(10)
                .wisdom(10)
                .charisma(10)
                .hp(11)
                .maxHp(11)
                .level(1)
                .build();
    }
}
