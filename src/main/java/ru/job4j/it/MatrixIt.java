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
        return (row < data.length - 1) || (column < data[row].length);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
             throw new NoSuchElementException();
        }

        int rsl = 0;
            while (data[row].length == 0) {
                row++;
                }
        if (column == data[row].length - 1) {
            rsl = data[row][column];
            row++;
        } else {
            rsl = data[row][column];
            column++;
        }
        return rsl;
    }
}