package ru.job4j.generics;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        int length = 0;
        int index = 0;
        //Objects.checkIndex(index, length);
        System.out.println(Objects.checkIndex(index, length));
    }
}
