package de.cade.languagesystem.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@AllArgsConstructor
public enum Language {

    GERMAN(new HashMap<>()), ENGLISH(new HashMap<>()), RUSSIAN(new HashMap<>());

    @Getter
    private HashMap<String, String> cache;

}
