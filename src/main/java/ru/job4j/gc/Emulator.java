package ru.job4j.gc;

public class Emulator {
    public static void main(String[] args) {
        Cash cash = new Cash();
        String rsl = cash.getString("Names.txt");
        System.out.println(rsl);
        rsl = cash.getString("Address.txt");
        System.out.println(rsl);
    }
}
