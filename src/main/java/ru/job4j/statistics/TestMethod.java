package ru.job4j.statistics;

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

    public static void main(String[] args) {
        List<User> previous = List.of(new User(01, "Ivan"),
                new User(02, "Egor"), new User(03, "Iliy"),
                new User(04, "Fedor"), new User(05, "Nikolay"));
        List<User> current = List.of(new User(02, "Egor"),
                new User(03, "Ivan"), new User(04, "Fedor"),
                new User(05, "Nikolay"), new User(06, "Ivan"));

        Map<Integer, User> previousMap = Analize.collect(previous);
        Map<Integer, User> currentMap = Analize.collect(current);
        Map<Integer, User> mergingMap = Analize.merging(previousMap, currentMap);
        System.out.println(mergingMap);
        System.out.println(currentMap);
        /*Analize analize = new Analize();
        Info forTest = analize.diff(previous, current);
        System.out.println(forTest);
        Info result = new Info(2);*/
    }
}
