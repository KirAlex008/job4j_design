package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trash extends AbstractStorageHandler {

    public Trash(Date today) {
        super(today);
    }

    @Override
    public boolean add(Food food) {
        boolean flag = false;
        int percentOfQuality = quality(food, today);
        if (percentOfQuality <= 0) {
            list.add(food);
            flag = true;
        } else {
            if(nextHandler !=null){
                //boolean d = nextHandler.add(food);
                nextHandler.add(food);
            }
        }
        return flag;
    }

    @Override
    public void clearAll() {
        this.list.clear();
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}
