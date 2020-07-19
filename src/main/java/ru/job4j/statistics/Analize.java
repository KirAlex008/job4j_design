package ru.job4j.statistics;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, User> mergingMap = Analize.collect(current);
        int addedCounter = 0;
        int deletedCounter = 0;
        int chengedCounter = 0;
        for (var el : previous) {

            if (!mergingMap.containsKey(el.getId())) {
                deletedCounter++;
            }
            if (mergingMap.containsKey(el.getId()) && !mergingMap.get(el.getId()).getName().equals(el.getName())) {
                chengedCounter++;
            }
            if (current.size() > previous.size()) {
                var difference = current.size() - previous.size();
                addedCounter = difference + deletedCounter;
            }

        }
        info.changed = chengedCounter;
        info.deleted = deletedCounter;
        info.added = addedCounter;
        return info;
        }

    public static Map<Integer, User> collect(List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(User::getId, user -> user,
                        (id1, id2) -> {
                            System.out.println("duplicate key found!");
                            return id1;
                        }));
    }
}
