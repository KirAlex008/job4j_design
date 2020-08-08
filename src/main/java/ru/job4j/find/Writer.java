package ru.job4j.find;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Writer {
    private List<Path> wordsToWrite;
    private String stringOfPath;

    public Writer(List<Path> wordsToWrite, String stringOfPath) {
        this.wordsToWrite = wordsToWrite;
        this.stringOfPath = stringOfPath;
    }

    public Path pathGet() {
        stringOfPath = "./" + stringOfPath;
        System.out.println(Paths.get(stringOfPath));
        return Paths.get(stringOfPath);
    }

    public void wordWrite() {
        Path path = pathGet();
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
        for (var el : wordsToWrite) {
            writer.write(el.toString() + System.lineSeparator());
        }
    } catch (Exception e) {
        e.printStackTrace();
        }
    }
}
