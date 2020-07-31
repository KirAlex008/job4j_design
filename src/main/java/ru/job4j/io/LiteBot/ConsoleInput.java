package ru.job4j.io.LiteBot;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }
}
