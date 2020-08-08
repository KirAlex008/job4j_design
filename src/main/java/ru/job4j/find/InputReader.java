package ru.job4j.find;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class InputReader {
    private final String[] args;

    public InputReader(String[] args) {
        this.args = args;
    }

    public boolean validateArgs() {
        boolean inputIsValid = true;
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments array are empty.");
        }
        if (args.length != 7) {
            throw new IllegalArgumentException("The amount of arguments is wrong.");
        }
        if (!Files.isDirectory(Paths.get(args[1]))) {
            throw new IllegalArgumentException("Directory is not exist");
        }
        if (!args[0].startsWith("-")
                || !args[2].startsWith("-")
                || !args[4].startsWith("-")
                || !args[5].startsWith("-")) {
            throw new IllegalArgumentException("Args must be started with -");
        }
        if (!args[0].equalsIgnoreCase("-d")
                || !args[2].equalsIgnoreCase("-n")
                || !args[4].equalsIgnoreCase("-o")) {
            throw new IllegalArgumentException("Wrong arg name!");
        }
        return inputIsValid;
    }
}
