package com.dndgame.gamecore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Action {
    private String id;
    private String text;
    private String nextLocationId;
    private Map<String, Object> effects;
}
