package com.dndgame.gamecore.repository;

import com.dndgame.gamecore.model.CombatState;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CombatStore {
    private final Map<String, CombatState> combats = new ConcurrentHashMap<>();

    public void put(String partyId, CombatState state) {
        combats.put(partyId, state);
    }

    public CombatState get(String partyId) {
        return combats.get(partyId);
    }

    public void remove(String partyId) {
        combats.remove(partyId);
    }
}