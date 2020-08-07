package ru.job4j.find;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateChoice {
    Predicate<Path> predicate;

    public Predicate<Path> choice(Map<String, String> keysArr) {
        if (keysArr.containsKey("m")) {
            var ext = keysArr.get("n");
            if (ext.contains("*")) {
                ext.substring(1);
            }
            predicate = p -> p.toFile().getName().endsWith(ext);
        }
        if (keysArr.containsKey("f")) {
            predicate = p -> p.toFile().getName().equals(keysArr.get("n"));
        }
        return predicate;
    }
}
