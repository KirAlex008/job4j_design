package ru.job4j.io;

import java.io.FileOutputStream;

public class TabPrint {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        int size = 3;
        int[][] table = TabPrint.multiple(size);
        try (FileOutputStream out = new FileOutputStream("Table.txt")) {
            for (var row : table) {
                size = 3;
                for (var el : row) {
                    String forBuff = Integer.toString(el);
                    forBuff = forBuff + " ";
                    if (size == 1) {
                        forBuff = forBuff + System.lineSeparator();
                    }
                    byte[] buffer = forBuff.getBytes();
                    out.write(buffer);
                    size = size - 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
