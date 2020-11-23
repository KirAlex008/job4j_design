package ru.job4j.foodstorage;

import java.util.List;

public interface Storage {
    boolean add(Food food);
    //boolean check();
    void setNextHandler(Storage nextHandler);

    List<Food> getList();
}
