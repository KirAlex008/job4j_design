package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            lines.addAll(in.lines().filter(line -> line.contains("404")).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (var el : log) {
                out.write(el + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = LogFilter.filter("log.txt");
        save(log, "404.txt");
        }
}
