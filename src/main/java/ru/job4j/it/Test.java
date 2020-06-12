package ru.job4j.it;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Iterator<Integer> it1 = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4, 5, 6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7, 8, 9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Iterator<Integer> it4 = Collections.emptyIterator();

        System.out.println(it1.next());
        System.out.println(it1.next());
        System.out.println(it1.next());
        System.out.println(its.hasNext());
        System.out.println(its.next());
        System.out.println(it4.hasNext());
    }

}
