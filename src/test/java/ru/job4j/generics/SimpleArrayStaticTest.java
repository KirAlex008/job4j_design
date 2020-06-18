package ru.job4j.generics;

import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayStaticTest {
    @Test (expected = IndexOutOfBoundsException.class)
    public void whenCreateContainerShoulsReturnTheSameType() {
        SimpleArrayStatic<String> simpleArrayStatic = new SimpleArrayStatic<String>(4);
        simpleArrayStatic.add("test");
        simpleArrayStatic.add("test2");
        simpleArrayStatic.set(1, "test3");

        String result = simpleArrayStatic.get(0);
        String result2 = simpleArrayStatic.get(1);

        assertThat(result, is("test"));
        assertThat(result2, is("test3"));

        simpleArrayStatic.remove(1);
        String result3 = simpleArrayStatic.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIsExeptionForSet() {
        SimpleArrayStatic<String> simpleArrayStatic = new SimpleArrayStatic<String>(4);
        simpleArrayStatic.set(5, "test3");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIsExeptionForRemove() {
        SimpleArrayStatic<String> simpleArrayStatic = new SimpleArrayStatic<String>(4);
        simpleArrayStatic.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIsExeptionForGet() {
        SimpleArrayStatic<String> simpleArrayStatic = new SimpleArrayStatic<String>(4);
        simpleArrayStatic.get(5);
    }

    @Test
    public void whenMultiCallhasNextThenTrue() {
        SimpleArrayStatic<Integer> simpleArrayStatic = new SimpleArrayStatic<Integer>(4);
        simpleArrayStatic.add(1);
        simpleArrayStatic.add(2);
        simpleArrayStatic.add(3);
        assertThat(simpleArrayStatic.iterator().hasNext(), Matchers.is(true));
        assertThat(simpleArrayStatic.iterator().hasNext(), Matchers.is(true));

    }

    @Test
    public void whenReadSequence() {
        SimpleArrayStatic<Integer> simpleArrayStatic = new SimpleArrayStatic<Integer>(4);
        simpleArrayStatic.add(1);
        simpleArrayStatic.add(2);
        simpleArrayStatic.add(3);
        assertThat(simpleArrayStatic.iterator().next(), Matchers.is(1));
        assertThat(simpleArrayStatic.iterator().next(), Matchers.is(2));
        assertThat(simpleArrayStatic.iterator().next(), Matchers.is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleArrayStatic<Integer> simpleArrayStatic = new SimpleArrayStatic<Integer>(0);
        simpleArrayStatic.iterator().next();
    }

}