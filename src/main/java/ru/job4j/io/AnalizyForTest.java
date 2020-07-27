package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnalizyForTest {

    public void unavailable(String source, String target) {
        List<String> container = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            String lineForWriting = "";
            while((line = reader.readLine()) != null) {
                if ((line.contains("400") || line.contains("500")) && (lineForWriting.equals(""))) {
                    var strArr = line.split(" ");
                    lineForWriting = lineForWriting + strArr[1] + ";";
                }
                if ((line.contains("200") || line.contains("300")) && (!lineForWriting.equals(""))) {
                    var strArr = line.split(" ");
                    lineForWriting = lineForWriting + strArr[1] + System.lineSeparator();
                    container.add(lineForWriting);
                    lineForWriting = "";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (var el : container) {
                writer.write(el);
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
