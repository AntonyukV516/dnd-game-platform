package com.dndgame.gamecore.repository;

import com.dndgame.gamecore.model.CombatState;

public interface CombatRepository {
    void put(String partyId, CombatState state);

    CombatState get(String partyId);

    void remove(String partyId);
}