package ru.job4j.foodstorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllQuality {

    private Storage chain;

    public ControllQuality(Storage chain) {
        this.chain = chain;
    }

    public void executor(List<Food> list) {
        for (Food el : list) {
            chain.add(el);
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        foodList.addAll(chain.getList());
        chain.clearAll();
        Storage storage = chain;
        for (int i = 1; i < StoragesChain.numberOfStorage(); i++ ) {
            foodList.addAll(storage.getNextHandler().getList());
            storage = storage.getNextHandler();
            storage.clearAll();
        }
        executor(foodList);
    }

    public Storage getChain() {
        return chain;
    }

    public static void main(String[] args) throws ParseException {
        Storage chain = StoragesChain.getChainOfStorage();
        ControllQuality control = new ControllQuality(chain);
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
        List<Food> list1 = control.getChain().getList();
        List<Food> list2 = control.getChain().getNextHandler().getList();
        List<Food> list3 = control.getChain().getNextHandler().getNextHandler().getList();
        for (Food el : list1){
            System.out.println(el.toString() + "1");
        }
        for (Food el : list2){
            System.out.println(el.toString() + "2");
        }
        for (Food el : list3){
            System.out.println(el.toString() + "3");
        }
        control.resort();

        list1 = control.getChain().getList();
        list2 = control.getChain().getNextHandler().getList();
        list3 = control.getChain().getNextHandler().getNextHandler().getList();
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
