package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray <T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;
    private int point = 0;
    private int size = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
        this.size = size;
    }
    public int size() {
        return size;
    }

    public void add(T value) {
        this.objects[index++] = value;
    }

    public T get(int position) {
        return (T) this.objects[Objects.checkIndex(position, index + 1)];
    }

    public void set(int position, T model) {
        this.objects[Objects.checkIndex(position, objects.length)] = model;
    }

    public void remove(int position) {
        int rsl = Objects.checkIndex(position, index + 1);
        System.arraycopy(objects, rsl + 1, objects,
                rsl, objects.length - 1 - rsl);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return point < objects.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[point++];
            }
        };
    }

}


