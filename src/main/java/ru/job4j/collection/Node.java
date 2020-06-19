package ru.job4j.collection;

public class Node <E> {
    E item;
    Node<E> next;
    //Node<E> prev;

    Node(E element) {
        this.item = element;
        //this.next = next;
       // this.prev = prev;
    }
}
