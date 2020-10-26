package ru.job4j.gc;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Reader {
    public static String wordsRead (String key) {
        StringJoiner str = new StringJoiner(System.lineSeparator());
        //String path = "./src/main/java/ru/job4j/io/LiteBot/words.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(key))) {
            in.lines().forEach(str::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}
