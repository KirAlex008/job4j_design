package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects;
    private int index = 0; // elements number of array
    private int point = 0; // iterator counter
    private int size; // array length
    private int modCount = 0; // counter for iterator
    private int elementData;

    public SimpleArray(int size) {
        if (size > DEFAULT_CAPACITY) {
            this.objects = new Object[size];
            this.size = size;
        } else {
            this.objects = new Object[DEFAULT_CAPACITY];
            this.size = DEFAULT_CAPACITY;
        }
    }

    public SimpleArray() {
        this.objects = new Object[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;
    }

    private void grow(int minCapacity) {
        this.objects = Arrays.copyOf(objects, 2 * size);
    }

    public void add(T value) {
        elementData++;
        if (elementData > size) {
            grow(size);
        }
        this.objects[index++] = value;
        modCount++;
    }

    public T get(int position) {
        return (T) this.objects[Objects.checkIndex(position, index)];
    }

    public void set(int position, T model) {
        this.objects[Objects.checkIndex(position, index)] = model;
    }

    public void remove(int position) {
        int rsl = Objects.checkIndex(position, index);
        System.arraycopy(objects, rsl + 1, objects,
                rsl, objects.length - 1 - rsl);
        index--;
        modCount--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount < modCount) {
                    throw new ConcurrentModificationException();
                }
                return point < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                modCount++;
                return (T) objects[point++];
            }
        };
    }

}