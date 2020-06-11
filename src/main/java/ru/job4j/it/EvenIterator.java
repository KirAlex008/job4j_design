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
        while(rsl == false && point < data.length) {
            while(data[point] % 2 == 0) {
                rsl = true;
                point = pointFirst;
                break;
            }
            point++;
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
        boolean even = false;
        while(even == false && point < data.length) {
            while(data[point] % 2 == 0) {
                rsl = data[point];
                even = true;
                point++;
                break;
            }
            if (even == false) {
                point++;
            }
        }
        return rsl;
    }
}
