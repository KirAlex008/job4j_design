package ru.job4j.menu;

public class ExampleAction implements UserAction{
    @Override
    public String name() {
        return "=== Action ====";
    }

    @Override
    public boolean execute() {
        System.out.println("=== Action ====");
        return false;
    }
}
