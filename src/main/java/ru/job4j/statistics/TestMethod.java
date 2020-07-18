package ru.job4j.statistics;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMethod {

    public static Map<Integer, User> collect(List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(User::getId, user -> user,
                        (id1, id2) -> {
                            System.out.println("duplicate key found!");
                            return id1;
                        }));
    }

    public static Map<Integer, User> merging(Map<Integer, User> previousMap, Map<Integer, User> currentMap) {
        return Stream.of(previousMap, currentMap)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (v1, v2) -> new User(v1.getId(), v2.getName())));
    }

    public static void merging3(List<User> previous, List<User> current) {
          Stream.of(current, previous)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(User::getId, user -> user,
                        (id1, id2) -> {
                            System.out.println("duplicate key found!");
                            return id1;
                        }))
                .entrySet()
                .forEach(el-> System.out.println(el));
    }

    public static Map<Integer, User> merging2(List<User> previous, List<User> current) {
        return Stream.of(current, previous)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(User::getId, user -> user,
                        (id2, id1) -> {
                            System.out.println("duplicate key found!");
                            return id2;
                        }));
    }

    public static void main(String[] args) {
        List<User> previous = List.of(new User(01, "Ivan"),
                new User(02, "Egor"), new User(03, "Iliy"),
                new User(04, "Fedor"), new User(05, "Nikolay"));
        List<User> current = List.of(new User(02, "Egor"),
                new User(03, "John"), new User(04, "Fedor"),
                new User(05, "Nikolay"), new User(06, "Ivan"), new User(07, "Semen"));

        Map<Integer, User> previousMap = Analize.collect(previous);
        Map<Integer, User> currentMap = Analize.collect(current);
        //Map<Integer, User> mergingMap = Analize.merging(previousMap, currentMap);
        TestMethod.merging3(previous, current);
        Map<Integer, User> mergingMap = Analize.merging2(previous, current);
        //System.out.println(previous + "previous");
        //System.out.println(current + "current");
       //System.out.println(previous.get(1));
       System.out.println(mergingMap);
        /*Analize analize = new Analize();
        Info forTest = analize.diff(previous, current);
        System.out.println(forTest);
        Info result = new Info(2);*/
    }
}
