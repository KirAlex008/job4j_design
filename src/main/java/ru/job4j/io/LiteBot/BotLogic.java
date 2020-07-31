package ru.job4j.io.LiteBot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BotLogic {
    List<String> wordsList;

    public BotLogic(List<String> wordsList) {
        this.wordsList = wordsList;
    }

    public boolean wordRecognition (String state) {
        boolean wordIsCommand = false;
        wordIsCommand = state.equals("stop") || state.equals("go on") || state.equals("exit");
        return wordIsCommand;
    }

    public String wordChose () {
        int targetNumber = (int) (Math.random() * wordsList.size());
        return wordsList.get(targetNumber);
    }


}
