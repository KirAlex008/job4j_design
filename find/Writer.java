package ru.job4j.find;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Writer {
    List<Path> wordsToWrite;
    String line;
    Path path = Paths.get("./log.txt");

    public Writer(List<Path> wordsToWrite) {
        this.wordsToWrite = wordsToWrite;
    }

    public void wordWrite() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
        for (var el : wordsToWrite) {
            writer.write(el.toString() + System.lineSeparator());
            System.out.println("Write");
        }
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
