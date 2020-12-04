package ru.job4j.foodstorage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoragesChain {

    private int counterOfStorage = 3;

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

    public static Storage getChainOfStorage() {
        warehouse.setNextHandler(shop);
        shop.setNextHandler(trash);
        return warehouse;
    }

    public static int numberOfStorage() {
        Storage storage = getChainOfStorage();
        int counter = 1;
        while (storage.getNextHandler() != null) {
            counter++;
            storage = storage.getNextHandler();
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(StoragesChain.numberOfStorage() + " 11");
    }
}
