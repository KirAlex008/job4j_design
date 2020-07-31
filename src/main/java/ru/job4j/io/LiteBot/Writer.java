package ru.job4j.io.LiteBot;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Writer {
    List<String> wordsToWrite;
    String line;
    Path path = Paths.get("./src/main/java/ru/job4j/io/LiteBot/log.txt");
    public Writer(List<String> wordsToWrite) {
        this.wordsToWrite = wordsToWrite;
    }

    public void wordWrite() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
        for (var el : wordsToWrite) {
            writer.write(el);
        }
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
