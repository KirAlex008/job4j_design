package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        ForwardLinked.Node<T> item = linked.deleteLast();
        return item.value;
    }

    public void push(T value) {
        linked.add(value);
    }

}