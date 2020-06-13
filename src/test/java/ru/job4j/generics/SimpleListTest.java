package ru.job4j.generics;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleListTest {

/*    @Test
    public void whenCreateContainerShoulsReturnTheSameType() {
        SimpleList<String> simpleList = new SimpleList<String>(4);
        simpleList.add("test");
        String result = simpleList.get(0);

        assertThat(result, is("test"));
    }*/

    @Test
    public void whenCreateContainerShoulsReturnTheSameType2 () {
        Stack simpleList = new Stack(4);
        simpleList.add(1);
        Integer result = simpleList.get(0);

        assertThat(result, is(1));
    }

   /* @Test
    public void whenIntShoulsReturnIntType() {
        SimpleList<Integer> simpleList = new SimpleList<Integer>(4);
        simpleList.add(2);
        Integer result = simpleList.get(0);

        assertThat(result, is(2));
    }*/

}