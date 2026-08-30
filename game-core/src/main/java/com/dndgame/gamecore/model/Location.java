package com.dndgame.gamecore.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Location {
    private String id;
    private String name;
    private LocationType type;
    private String descriptionFile;
    private List<Action> actions;
}
