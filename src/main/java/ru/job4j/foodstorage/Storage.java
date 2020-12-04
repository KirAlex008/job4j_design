package ru.job4j.foodstorage;

import java.util.List;

public interface Storage {
    boolean add(Food food);
    List<Food> getAll();
    void setNextHandler(Storage nextHandler);
    Storage getNextHandler();
    List<Food> getList();
    public void clearAll();
}
