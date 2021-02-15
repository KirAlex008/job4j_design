package ru.job4j.game;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int getNumber(String num) { // in Input
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.parseInt(askStr(num));
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
                invalid = false;
            }
        } while (invalid);
        return value;
    }
}
