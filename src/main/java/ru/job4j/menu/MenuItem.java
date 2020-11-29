package ru.job4j.menu;

public class MenuItem {
    String name;
    int number;
    UserAction action;

    public MenuItem(String name, int number, UserAction action) {
        this.name = name;
        this.number = number;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public UserAction getAction() {
        return action;
    }

    public void setAction(UserAction action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return name;
    }
}
