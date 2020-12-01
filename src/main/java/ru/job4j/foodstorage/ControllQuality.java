package ru.job4j.foodstorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllQuality {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static Date today;

    static {
        try {
            today = sdf.parse(sdf.format(new Date(2020, 11, 20)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static AbstractStorageHandler warehouse = new WareHouse(today);
    private static AbstractStorageHandler shop = new Shop(today);
    private static AbstractStorageHandler trash = new Trash(today);

    public AbstractStorageHandler getWarehouse() {
        return warehouse;
    }

    public AbstractStorageHandler getShop() {
        return shop;
    }

    public AbstractStorageHandler getTrash() {
        return trash;
    }

    public static int quality(Food food, Date today){
        long periodOfGoodQuality = food.expaireDate.getTime() - food.createDate.getTime();
        long lastTimeOfGooDQuality = food.expaireDate.getTime() - today.getTime();
        int percentOfQuality = (int) (lastTimeOfGooDQuality * 100 / periodOfGoodQuality);
        //int days =  (int)(periodOfGoodQuality / (24 * 60 * 60 * 1000));
        return percentOfQuality;
    }

    public static Storage getChainOfStorage() {
        warehouse.setNextHandler(shop);
        shop.setNextHandler(trash);
        return warehouse;
    }

    public void executor(List<Food> list) {
        Storage handlerChain = getChainOfStorage();
        for (Food el : list) {
            handlerChain.add(el);
        }
    }
    public void resort(Date today) {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(warehouse.getList());
        foodList.addAll(shop.getList());
        AbstractStorageHandler warehouse = new WareHouse(today);
        AbstractStorageHandler shop = new Shop(today);
        AbstractStorageHandler trash = new Trash(today);
        warehouse.setNextHandler(shop);
        shop.setNextHandler(trash);
        Storage handlerChain = warehouse;
        for (Food el : foodList) {
            handlerChain.add(el);
        }
    }


    public static void main(String[] args) throws ParseException {
        ControllQuality control = new ControllQuality();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date today = sdf.parse(sdf.format(new Date(2020, 11, 20)));
        Date expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 30)));
        Date createDate = sdf.parse(sdf.format(new Date(2020, 11, 17)));
        Food food1 = new Food1("food1",expaireDate, createDate, 100, 30);
        expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 25)));
        createDate = sdf.parse(sdf.format(new Date(2020, 11, 17)));
        Food food2 = new Food1("food2",expaireDate, createDate, 100, 30);
        expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 22)));
        createDate = sdf.parse(sdf.format(new Date(2020, 11, 10)));
        Food food3 = new Food1("food3",expaireDate, createDate, 100, 30);
        expaireDate = sdf.parse(sdf.format(new Date(2020, 11, 19)));
        createDate = sdf.parse(sdf.format(new Date(2020, 11, 10)));
        Food food4 = new Food1("food4",expaireDate, createDate, 100, 30);
        List<Food> list = List.of(food1,food2, food3, food4);
        control.executor(list);
        List<Food> list1 = control.getWarehouse().getList();
        List<Food> list2 = control.getShop().getList();
        List<Food> list3 = control.getTrash().getList();
        for (Food el : list1){
            System.out.println(el.toString() + "1");
        }
        for (Food el : list2){
            System.out.println(el.toString() + "2");
        }
        for (Food el : list3){
            System.out.println(el.toString() + "3");
        }
        control.resort(new Date(2020, 12, 1));
        List<Food> list4 = control.getWarehouse().getList();
        List<Food> list5 = control.getShop().getList();
        List<Food> list6 = control.getTrash().getList();
        for (Food el : list1){
            System.out.println(el.toString() + "1");
        }
        for (Food el : list2){
            System.out.println(el.toString() + "2");
        }
        for (Food el : list3){
            System.out.println(el.toString() + "3");
        }
    }
}
