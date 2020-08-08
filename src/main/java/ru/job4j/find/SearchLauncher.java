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
        inputArgs.validateArgs();
        PredicateChoice predicateOfSearch = new PredicateChoice(args); // выбор предиката
        List<Path> listOfFiles = Search.search(Paths.get(args[1]), predicateOfSearch.choice()); // поиск в каталоге с предикатом
        Writer writer = new Writer(listOfFiles, args[6]);
        writer.wordWrite();
    }
}
