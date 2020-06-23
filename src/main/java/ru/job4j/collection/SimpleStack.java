package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int length = 0;

    public T pop() {
        T value = linked.deleteLast();
        length--;
        return value;
    }

    public void push(T value) {
        linked.add(value);
        length++;
    }

    public int getLength() {
        return length;
    }
}