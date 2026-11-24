package com.dndgame.gamecore.service.monster;

import com.dndgame.gamecore.model.MonsterType;
import com.dndgame.gamecore.model.Player;

public interface MonsterFactory {

    MonsterType getType();

    Player create();
}
