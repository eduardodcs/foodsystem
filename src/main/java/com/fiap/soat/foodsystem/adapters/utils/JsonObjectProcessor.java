package com.fiap.soat.foodsystem.adapters.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Component
public class JsonObjectProcessor {

    private final Gson gson;

    public JsonObjectProcessor() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
        gsonBuilder.registerTypeAdapter(Instant.class, new InstantAdapter());
        this.gson = gsonBuilder.create();
    }

    public <T> T processJsonObject(JsonObject jsonObject, Class<T> clazz) {
        return gson.fromJson(jsonObject, clazz);
    }
}

