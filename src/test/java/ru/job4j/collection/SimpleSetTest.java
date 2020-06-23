package ru.job4j.collection;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class SimpleSetTest {
    @Test
    public void when2Zero() {
        SimpleSet<String> set = new SimpleSet<String>();
        Set<String> setTest = new HashSet<String>();
        set.add("first");
        set.add("zero");
        set.add("second");
        set.add("third");
        set.add("zero");
        setTest.add("first");
        setTest.add("zero");
        setTest.add("second");
        setTest.add("third");
        setTest.add("zero");
        assertThat(set, is(setTest));
    }

}