package ru.job4j.find;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateChoice {
    Predicate<Path> predicate;
    String[] args;

    public PredicateChoice(String[] args) {
        this.args = args;
    }

    public Predicate<Path> choice() {
        if (args[4].equals("-m") && args[3].contains("*")) {
            predicate = p -> p.toFile().getName().endsWith(args[3].substring(1));
        } else if (args[3].contains("f")) {
            predicate = p -> p.toFile().getName().equals(args[3]);
        }
        return predicate;
    }
}
