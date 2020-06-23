package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T>{

    private SimpleArray<T> set = new SimpleArray<T>();

    public boolean add(T value) {
        T elemToAdd = value;
        boolean rsl = true;
        for (T elem : set) {
            if (elem.equals(value)){
                rsl = false;
                break;
            }
        }
        set.add(elemToAdd);
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(set, simpleSet.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
*/
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
