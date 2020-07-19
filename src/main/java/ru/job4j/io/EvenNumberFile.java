package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            char[] buffer = new char[text.length()];
            String str = "";
            text.getChars(0, text.length(), buffer, 0);
            for (var el : buffer) {
                if (el == 10 || el == 13) {
                    str = str + " ";
                } else {
                    str = str + el;
                }
            }
            for (String el : str.split("  ")) {
                Integer.parseInt(el);
                if (Integer.parseInt(el) % 2 != 0) {
                    System.out.println(el);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
