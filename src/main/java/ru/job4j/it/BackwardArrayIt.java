package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;
    private int count = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        count++;
        return point >= 0 ;
    }

    @Override
    public Integer next() {
        if (point == 0 && count == 0) {
            point = data.length - 1;
        }
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}