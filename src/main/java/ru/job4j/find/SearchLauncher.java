package ru.job4j.find;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class SearchLauncher {
    public static void main(String[] args) throws IOException {
        InputReader inputArgs = new InputReader(args); // получает из строки ввода команды, возвращает массив ключей
        inputArgs.concatenateArgs();
        inputArgs.read();
        inputArgs.validateArgs();
        Map<String, String> keysArr = inputArgs.getInputKeys();
        PredicateChoice predicateOfSearch = new PredicateChoice(); // выбор предиката
        List<Path> listOfFiles = Search.search(Paths.get(keysArr.get("d")), predicateOfSearch.choice(keysArr)); // поиск в каталоге с предикатом
        System.out.println(keysArr.get("o"));
        Writer writer = new Writer(listOfFiles, keysArr.get("o"));
        writer.wordWrite();
    }
}
