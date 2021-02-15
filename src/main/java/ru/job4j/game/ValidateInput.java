package ru.job4j.game;

public class ValidateInput implements Input{
    int[] coord = new int[3];

    @Override
    public String askStr(String question) {
        return question;
    }

    @Override
    public int getNumber(String num) { // in Input
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.parseInt(askStr(num));
                //invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
                invalid = false;
            }
        } while (invalid);
        return value;
    }
}
