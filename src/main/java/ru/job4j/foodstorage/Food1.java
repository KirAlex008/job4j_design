package ru.job4j.foodstorage;

import java.time.LocalDate;
import java.util.Date;

public class Food1 extends Food{
    public Food1(String name, Date expaireDate, Date createDate, double price, double disciount) {
        super(name, expaireDate, createDate, price, disciount);
    }
}
