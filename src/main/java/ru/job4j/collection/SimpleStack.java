package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private ForwardLinked.Node<T> head = linked.getHead();

    public T pop() {
        T value = linked.deleteLast();
        return value;
    }

    public void push(T value) {
        linked.add(value);
    }

    public ForwardLinked.Node<T> getHead() {
        return head;
    }
}