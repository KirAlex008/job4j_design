package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractStorageHandler implements Storage{

    public Storage nextHandler;
    public Date today;
    List<Food> list = new ArrayList<>();

    public AbstractStorageHandler(Date today) {
        //this.nextHandler = nextHandler;
        this.today = today;
    }

    public static int quality(Food food, Date today){
        long periodOfGoodQuality = food.expaireDate.getTime() - food.createDate.getTime();
        long lastTimeOfGooDQuality = food.expaireDate.getTime() - today.getTime();
        int percentOfQuality = (int) (lastTimeOfGooDQuality * 100 / periodOfGoodQuality);
        //int days =  (int)(periodOfGoodQuality / (24 * 60 * 60 * 1000));
        return percentOfQuality;
    }

    @Override
    public abstract boolean add(Food food);

    @Override
    public List<Food> getAll() {
        List<Food> allFood = null;
        if(this.getList().size() != 0 && this.nextHandler != null) {
            allFood.addAll(this.getList());
        }
        if(this.nextHandler == null) {
            allFood.addAll(this.getList());
            System.out.println("Test");
        }
        return allFood;
    }

    @Override
    public abstract void clearAll();


    @Override
    public void setNextHandler(Storage nextHandler){
        this.nextHandler = nextHandler;
    }

    @Override
    public Storage getNextHandler() {
        Storage rsl = null;
        if(this.nextHandler != null) {
            rsl = this.nextHandler;
        }
        return rsl;
    }

    @Override
    public List<Food> getList() {
        return list;
    }


}
