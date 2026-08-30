package com.dndgame.gamecore.service;

import com.dndgame.gamecore.model.Location;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ContentLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String basePath = System.getProperty("user.dir") + "/../game-content/prologue/";

    public Location loadLocation(String locationId) {
        try {
            String json = Files.readString(Path.of(basePath + "locations/" + locationId + ".json"));
            return objectMapper.readValue(json, Location.class);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось загрузить локацию " + locationId, e);
        }
    }

    public String loadText(String fileName) {
        try {
            return Files.readString(Path.of(basePath + "texts/" + fileName));
        } catch (Exception e) {
            throw new RuntimeException("Не удалось загрузить текст " + fileName, e);
        }
    }
}