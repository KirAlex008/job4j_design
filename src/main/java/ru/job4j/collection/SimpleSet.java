package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T>{

    private SimpleArray<T> set = new SimpleArray<T>();

    public boolean add(T value) {
        boolean rsl = true;
        if (set.contains(value)){
                rsl = false;
            } else {
            set.add(value);
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return this.set.iterator();
    }

    public static void main(String[] args) {
        SimpleSet<String> set2 = new SimpleSet<String>();

        set2.add("first");
        set2.add("zero");
        set2.add("second");
        set2.add("third");
        set2.add("zero");

        for (String value : set2) {
            System.out.println(value);
        }
    }
}
