package ru.job4j.io.LiteBot;

import java.util.ArrayList;
import java.util.List;

public class StartBot {
    boolean workState = true;
    List<String> wordsToWrite = new ArrayList<>();

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        BotLogic botLogic = new BotLogic(Reader.wordsRead());
        StartBot bot = new StartBot();
        bot.init(input, botLogic);
    }

    public void init(Input input, BotLogic botLogic) {
        String answerWodr;
        String questionWord;
        for (boolean run = true; run;) {
            showInstructions();
            String select = input.askStr("Write your chose: ");

            if (!botLogic.wordRecognition(select) && workState == true) {
                questionWord = select;
                System.out.println("User say: " + questionWord);
                wordsToWrite.add("User say: " + questionWord + System.lineSeparator());

                answerWodr =  botLogic.wordChose();
                System.out.println("Bot say: " + answerWodr);
                wordsToWrite.add("Bot say: " + answerWodr + System.lineSeparator());

            }
            if (botLogic.wordRecognition(select) && select.equals("stop")) {
                workState = false;
            }
            if (botLogic.wordRecognition(select) && select.equals("go on")) {
                workState = true;
            }
            if (select.equals("exit") && botLogic.wordRecognition(select)) {
                run = false;
                workState = false;
                Writer writer = new Writer(wordsToWrite);
                writer.wordWrite();
            }
        }
    }

    private static void showInstructions() {
        System.out.println("Instructions:");
        System.out.println("Enter the word. If the word is 'stop' Bot will stop working.");
        System.out.println("If the word is 'go on' Bot will working.");
        System.out.println("Other words gives the answer.");
    }
}
