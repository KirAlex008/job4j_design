package ru.job4j.game;

import java.util.List;

public interface Player {
    int[] choiceCell(Input input);
    void move(Field field, Input input);
}
