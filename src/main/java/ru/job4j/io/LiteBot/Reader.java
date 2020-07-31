package ru.job4j.io.LiteBot;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<String> wordsRead () {
        List<String> wordsList = new ArrayList<String>();
        String line;
        String path = "./src/main/java/ru/job4j/io/LiteBot/words.txt";
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while ((line = in.readLine()) != null) {
                wordsList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsList;
    }
}
