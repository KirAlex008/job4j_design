package ru.job4j.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class SimpleLinkedList<E> implements Iterable<E> {

    private Node first; // first element of a list
    private Node last; // first element of a list

    public SimpleLinkedList () {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public E get(int index) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
