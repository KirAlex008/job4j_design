package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shop extends AbstractStorageHandler{

    List<Food> list = new ArrayList<>();

    public Shop(Date today) {
        super(today);
    }

    @Override
    public boolean add(Food food) {
        boolean flag = false;
        int percentOfQuality = quality(food, today);
        if (percentOfQuality < 75 && percentOfQuality > 25) {
            list.add(food);
            flag = true;
        }
        if (percentOfQuality < 25 && percentOfQuality > 0) {
            food.setPrice(food.getPrice() - food.getDisciount());
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
    public List<Food> getList() {
        return list;
    }

}
