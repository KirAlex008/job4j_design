package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        T value = linked.deleteLast();
        return value;
    }

    public void push(T value) {
        linked.add(value);
    }
}