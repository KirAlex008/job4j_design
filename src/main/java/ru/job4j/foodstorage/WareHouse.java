package ru.job4j.foodstorage;

import java.util.*;

public class WareHouse extends AbstractStorageHandler{



    public WareHouse(Date today) {
        super(today);
    }

    @Override
    public boolean add(Food food) {
        boolean flag = false;
        int percentOfQuality = quality(food, today);
        if (percentOfQuality > 75) {
            list.add(food);
            flag = true;
        } else {
            if(nextHandler !=null){
                nextHandler.add(food);
            }
        }
        return flag;
    }

    public void get(int i) {
        list.get(i);
    }

    @Override
    public List<Food> getList() {
        return list;
    }

}
