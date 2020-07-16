package ru.job4j.statistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0,0,0);
        Map<Integer, User> previousMap = Analize.collect(previous);
        Map<Integer, User> currentMap = Analize.collect(current);
        Map<Integer, User> mergingMap = Analize.merging(previousMap, currentMap);
        info.added = addedCounter(previousMap, currentMap);
        info.deleted = deletedCounter(previousMap, currentMap);
        info.changed = changedCounter(previousMap, currentMap, mergingMap);
        return info;
    }

    public int  addedCounter(Map<Integer, User> previousMap, Map<Integer, User> mergingMap) {
        int counter = 0;
        for (var el : mergingMap.keySet()) {
            if (!previousMap.containsKey(el)) {
                counter++;
            }
        }
        return counter;
    }

    public int deletedCounter(Map<Integer, User> mergingMap, Map<Integer, User> currentMap) {
        int counter = 0;
        for (var el : mergingMap.keySet()) {
            if (!currentMap.containsKey(el)) {
                counter++;
            }
        }
        return counter;
    }

    public int  changedCounter(Map<Integer, User> previousMap,
                               Map<Integer, User> currentMap, Map<Integer, User> mergingMap) {
        int counter = 0;
        for (var el : mergingMap.keySet()) {
            if (previousMap.containsKey(el) && currentMap.containsKey(el)) {
                User userPrevious = previousMap.get(el);
                User userCurrent = currentMap.get(el);
                if (!userCurrent.name.equals(userPrevious.name)) {
                    counter++;
                }
            }
        }
        return counter;
    }

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

}
