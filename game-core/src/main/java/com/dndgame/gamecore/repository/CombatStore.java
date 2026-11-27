package com.dndgame.gamecore.repository;

import com.dndgame.gamecore.model.CombatState;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CombatStore implements CombatRepository {
    private final Map<String, CombatState> combats = new ConcurrentHashMap<>();

    @Override
    public void put(String partyId, CombatState state) {
        combats.put(partyId, state);
    }

    @Override
    public CombatState get(String partyId) {
        return combats.get(partyId);
    }

    @Override
    public void remove(String partyId) {
        combats.remove(partyId);
    }
}