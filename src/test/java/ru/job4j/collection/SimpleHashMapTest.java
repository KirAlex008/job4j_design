package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMapTest {
    @Test
    public void whenInsertThenGetAndDelete() {
        SimpleHashMap<String, String> map = new  SimpleHashMap<>();
        map.insert("first", "a");
        map.insert("second", "b");
        String rsl = map.get("first");
        assertThat(rsl, is("a"));
        map.delete("first");
        assertThat(map.get("first"), is(IsNull.nullValue()));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<String, String> map = new  SimpleHashMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleHashMap<String, String> map = new  SimpleHashMap<>();
        map.insert("first", "a");
        Iterator<String> it = map.iterator();
        map.insert("second", "b");
        it.next();
    }
}