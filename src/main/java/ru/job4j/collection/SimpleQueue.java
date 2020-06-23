package ru.job4j.collection;

import java.util.Iterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int index = 0;

    public void push(T value) {
        in.push(value);
        index++;
    }

    public T poll() {
       for (int i = index; i > 0; i--) {
           out.push(in.pop());
        }
       T rsl = out.pop();
       index--;
        for (int i = index; i > 0; i--) {
            in.push(out.pop());
        }
       return rsl;
    }
}