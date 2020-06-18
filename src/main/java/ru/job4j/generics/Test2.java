package ru.job4j.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public class Test2 {
    public static void main(String[] args) {
        int length = 0;
        int index = 0;
        //Objects.checkIndex(index, length);
        System.out.println(Objects.checkIndex(index, length));
    }
}
