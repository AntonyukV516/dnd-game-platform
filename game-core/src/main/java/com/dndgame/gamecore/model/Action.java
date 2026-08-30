package com.dndgame.gamecore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Action {
    private String id;
    private String text;
    private String nextLocationId;
}
