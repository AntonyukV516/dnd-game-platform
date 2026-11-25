package com.dndgame.gamecore.service.monster;

import com.dndgame.gamecore.model.MonsterType;
import com.dndgame.gamecore.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MonsterRegistry {
    private final Map<MonsterType, MonsterFactory> factories;

    public MonsterRegistry(List<MonsterFactory> all) {
        this.factories = all.stream()
                .collect(Collectors.toMap(MonsterFactory::getType, Function.identity()));
    }

    public Player create(MonsterType type) {
        MonsterFactory factory = factories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Нет фабрики для монстра: " + type);
        }
        return factory.create();
    }

}