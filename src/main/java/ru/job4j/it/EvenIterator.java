package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public EvenIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        int pointFirst = point;
        if (data[point] % 2 == 1) {
            while(rsl == false && point < data.length) {
                point++;
                if (point < data.length && data[point] % 2 == 0) {
                    pointFirst = point;
                    rsl = true;
                    break;
                }
            }
        } else {
            rsl = true;
        }
        point = pointFirst;
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = 0;
            if (data[point] % 2 == 0) {
                rsl = data[point];
                point++;
            } else {
                point++;
            }
        return rsl;
    }
}
