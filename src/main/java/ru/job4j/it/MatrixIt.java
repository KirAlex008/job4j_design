package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = !((row == data.length - 1) && (0 == data[row].length)) ||
                        (row < data.length) && (column < data[row].length);
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
             throw new NoSuchElementException();
        }
        int rsl = 0;
            if (data[row].length == 0) {
                for (int i = row; i <= data.length; i++) {
                    row++;
                    if (data[row].length != 0) {
                        rsl = data[row][column];
                        break;
                    }
                }
                row++;
                } else {
                if (column == data[row].length - 1) {
                    rsl = data[row][column];
                    row++;
                } else {
                    rsl = data[row][column];
                    column++;
                }
            }
        return rsl;
    }
}