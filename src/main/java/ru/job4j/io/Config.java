package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    private Map<String, String> values1 = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> lines1 = new ArrayList<String>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            lines1.addAll(read.lines().filter(line -> !(line.contains("##") || line.isEmpty())).collect(Collectors.toList()));
            values1 = lines1.stream().map(s -> s.split("=", 2))
                    .collect(Collectors.toMap(s -> s[0], s -> s[1]));
            for (var el : values1.entrySet()) {
                values.put(el.getKey(), el.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values1.get(key);
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
        String path = "./src/main/java/ru/job4j/io/app2.txt";
        Config conf = new Config(path);
    }
}
