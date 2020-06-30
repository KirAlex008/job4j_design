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


    @Test
    public void whenTesting() {
        SimpleHashMap<String, String> map = new  SimpleHashMap<>();
        map.insert("A1", "a");
        map.insert("A2", "b");
        map.insert("A3", "c");
        map.insert("A4", "d");
        map.insert("A5", "i");
        map.insert("A6", "f");
        map.insert("A7", "g");
        map.insert("A8", "h");
        map.insert("A9", "j");

        //map.iterator().next();

       /* for (int i = 0; i < 9; i++) {
            System.out.println(map.iterator().next());
        }*/

        /*System.out.println("A1".hashCode());
        System.out.println("A2".hashCode());
        System.out.println("A3".hashCode());
        System.out.println("A4".hashCode());
        System.out.println("A5".hashCode());
        System.out.println("A6".hashCode());
        System.out.println("A7".hashCode());
        System.out.println("A8".hashCode());
        System.out.println("A9".hashCode());*/

        //System.out.println("A3".equals(obj1));
        System.out.println(map.get("A1"));
        System.out.println(map.get("A2"));
        System.out.println(map.get("A3"));
        System.out.println(map.get("A4"));
        System.out.println(map.get("A5"));
        System.out.println(map.get("A6"));
        System.out.println(map.get("A7"));
        System.out.println(map.get("A8"));
        System.out.println(map.get("A9"));


    }
}