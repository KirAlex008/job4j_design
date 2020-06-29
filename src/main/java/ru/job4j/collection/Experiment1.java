package ru.job4j.collection;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Experiment1 {
    User obj1 = new User("Mark0", 0, new GregorianCalendar(1900, 0,1));
    User obj2 = new User("Mark0", 0, new GregorianCalendar(1900, 0,1));
    Map<User, Object> map1 = new HashMap<>();

    @Test
    public void map() {
        map1.put(obj1, "first");
        map1.put(obj2, "second");
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj2.equals(obj1));
        System.out.println(map1 );

    }


}
