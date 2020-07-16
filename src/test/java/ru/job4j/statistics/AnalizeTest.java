package ru.job4j.statistics;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void add() {

        List<User> previous = List.of(new User(01, "Ivan"),
                new User(02, "Egor"), new User(03, "Iliy"),
                new User(04, "Fedor"), new User(05, "Nikolay"));
        List<User> current = List.of(new User(02, "Egor"),
                new User(03, "Ivan"), new User(04, "Fedor"),
                new User(05, "Nikolay"), new User(06, "Ivan"), new User(07, "Semen"));

        Analize analize = new Analize();
        Info forTest = analize.diff(previous, current);
        System.out.println(forTest);
        Info result = new Info(2,1,1);
        //Assert.assertEquals(forTest, result);
        assertThat(forTest, is(result));
    }


}