package ru.job4j.foodstorage;

import java.time.LocalDate;
import java.util.Date;

public abstract class Food {
    String name;
    Date expaireDate;
    Date createDate;
    double price;
    double disciount;

    public Food(String name, Date expaireDate, Date createDate, double price, double disciount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disciount = disciount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Date expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDisciount() {
        return disciount;
    }

    public void setDisciount(double disciount) {
        this.disciount = disciount;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", expaireDate=" + expaireDate +
                ", createDate=" + createDate +
                ", price=" + price +
                ", disciount=" + disciount +
                '}';
    }
}
