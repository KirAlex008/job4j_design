package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {

    public void unavailable(String source, String target) {
        List<String[]> container = new ArrayList<>();
        String start = "";
        String stop = "";
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            container.addAll(read.lines().filter(line -> !(line.isEmpty()))
                    .map(s -> s.split(" ", 2))
                    .collect(Collectors.toList()));
            for (int i = 0; i < container.size(); i++) {
                if ((container.get(i)[0].equals("400") || container.get(i)[0].equals("500"))
                        && (i < container.size() - 1)
                        && (container.get(i + 1)[0].equals("200") || container.get(i + 1)[0].equals("300"))) {
                    start = container.get(i)[1];
                }
                if ((container.get(i)[0].equals("200") || container.get(i)[0].equals("300"))
                        && (i < container.size() - 1)
                        && (!start.equals(""))
                        && (container.get(i + 1)[0].equals("400") || container.get(i + 1)[0].equals("500"))) {
                    stop =  container.get(i)[1];
                }
                if ((container.get(i)[0].equals("200") || container.get(i)[0].equals("300"))
                        && (i == container.size() - 1)) {
                    stop =  container.get(i)[1];
                }
                if (!start.equals("") && !stop.equals("")) {

                    try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                            new FileOutputStream(target, true)))) {
                        out.write(start + ";" + stop + System.lineSeparator());
                        start = "";
                        stop = "";
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        File file = new File("unavailable.csv");
        file.delete();
        analizy.unavailable("server.log", "unavailable.csv");
        try (BufferedReader read = new BufferedReader(new FileReader("unavailable.csv"))) {
            List<String> lines = new ArrayList<String>();
            read.lines().forEach(lines::add);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}