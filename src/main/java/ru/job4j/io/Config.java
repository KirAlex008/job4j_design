package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.CharBuffer;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(line -> !(line.contains("#")
                    || line.isEmpty()
                    || !line.contains("="))
                    || line.substring(line.length()).equals("="))
                    .map(s -> s.split("=", 2))
                    .forEach(s -> values.put(s[0],s[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String path = "./src/main/java/ru/job4j/io/app.txt";
        Config conf = new Config(path);

        //conf.load();
        System.out.println(conf.toString());



    }
}
