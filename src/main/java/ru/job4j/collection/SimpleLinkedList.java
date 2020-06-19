package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {

    private Node first; // first element of a list
    private Node last; // first element of a list
    private int modCount = 0; // counter for iterator
    private int index = 0; // elements number of array

    public SimpleLinkedList () {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node getFirst(Node n) {
        return first;
    }

    public void add(E value) {
        Node<E> newNode = new Node(value);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        modCount++;
        index++;
    }

    public E get(int position) {
        int pos = Objects.checkIndex(position, index);
        int count = 0;
        Node<E> rsl = first;
        while (count != pos) {
            rsl = rsl.next;
            count++;
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            private Node<E> point = first; // iterator current link
            private Node<E> previousPoint; // iterator previous link

            public void reset() {
                point = first;
            }

            @Override
            public boolean hasNext() {
                boolean rsl = true;
                if (expectedModCount < modCount) {
                    throw new ConcurrentModificationException();
                }
                if (point == null) {
                    rsl =false;
                }
                return rsl;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                modCount++;
                return (E) point;
            }
        };
    }
}
