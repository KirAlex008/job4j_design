package ru.job4j.generics;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.collection.SimpleArray;

import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenCreateContainerShoulsReturnTheSameType() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(4);
        simpleArray.add("test");
        simpleArray.set(1, "test2");

        String result = simpleArray.get(0);
        String result2 = simpleArray.get(1);

        assertThat(result, is("test"));
        assertThat(result2, is("test2"));

        simpleArray.remove(1);
        String result3 = simpleArray.get(1);
        String expected = null;
        assertThat(result3, is(expected));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIsExeptionForSet() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(4);
        simpleArray.set(5, "test3");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIsExeptionForRemove() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(4);
        simpleArray.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIsExeptionForGet() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(4);
        simpleArray.get(5);
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(4);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(simpleArray.iterator().hasNext(), Matchers.is(true));
        assertThat(simpleArray.iterator().hasNext(), Matchers.is(true));

    }

    @Test
    public void whenReadSequence() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(4);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(simpleArray.iterator().next(), Matchers.is(1));
        assertThat(simpleArray.iterator().next(), Matchers.is(2));
        assertThat(simpleArray.iterator().next(), Matchers.is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(0);
        simpleArray.iterator().next();
    }

}