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
        Map<Integer, User> mergingMap = Analize.merging2(previous, current);
        int addedCounter = 0;
        int deletedCounter = 0;
        int chengedCounter = 0;
        for (var el : mergingMap.keySet()) {
            var forComparison = mergingMap.get(el);
            if (!previous.contains(forComparison)) {
                addedCounter++;
            }
            if (!current.contains(forComparison) && previous.contains(forComparison)) {
                for (var user : current) {
                    if (user.id.equals(el) && !user.name.equals(mergingMap.get(el).name)) {
                        chengedCounter++;
                    }
                }
            }
            if (!current.contains(forComparison)) {
                deletedCounter++;
            }
        }
        deletedCounter = deletedCounter - chengedCounter;
        info.changed = chengedCounter;
        info.deleted = deletedCounter;
        info.added = addedCounter;
        return info;
        }

    public static Map<Integer, User> merging2(List<User> previous, List<User> current) {
        return Stream.of(previous, current)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(User::getId, user -> user,
                        (id1, id2) -> {
                            //System.out.println("duplicate key found!");
                            return id1;
                        }));
    }
}
