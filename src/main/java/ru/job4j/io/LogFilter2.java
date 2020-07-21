package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogFilter2 {
    public static List<String> filter(String file) {
        List<String> linesForReturn = new ArrayList<String>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<String>();
            List<String> wordsArray = new ArrayList<String>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equals("404")) {
                        wordsArray.add(line);
                        break;
                    }
                }
            }
            lines.clear();
            for (String elem : wordsArray) {
                String[] words = elem.split(" ");
                lines.addAll(Arrays.asList(words));
                for (int i = 0; i < lines.size(); i++) {
                    if(lines.get(i).equals("404") && isNumeric(lines.get(i + 1))) {
                        linesForReturn.add(elem);
                        lines.clear();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linesForReturn;
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        List<String> log = LogFilter.filter("log.txt");
        for (var el : log) {
            System.out.println(el);
        }
    }
}
