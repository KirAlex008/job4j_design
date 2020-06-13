package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            private Iterator<Integer> curIt = it.next();

            @Override
            public boolean hasNext() {
                while (!curIt.hasNext() && it.hasNext()) {
                    curIt = it.next();
                }
                return curIt.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext() && !it.hasNext() && curIt.hasNext()) {
                    throw new NoSuchElementException();
                }
                return curIt.next();
            }
        };
    }
}
