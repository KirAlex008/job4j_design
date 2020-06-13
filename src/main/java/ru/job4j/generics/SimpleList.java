package ru.job4j.generics;

import java.lang.reflect.ParameterizedType;

public class SimpleList<E> {
    Object[] objects;
    int index = 0;

    public SimpleList(int size) {
        this.objects = new Object[size];
        Class<E> t = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments() [0];
        try {
            E value = t.newInstance();
            System.out.printf("string " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void add(E value) {
        this.objects[index++] = value;
    }

    public E get(int position) {
        return (E) this.objects[position];
    }
}
