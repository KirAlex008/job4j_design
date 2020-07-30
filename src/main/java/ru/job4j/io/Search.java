package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null.");
        }
        if (args.length < 2 || args.length > 2) {
            throw new IllegalArgumentException("The amount of arguments is wrong.");
        }
        Path start = Paths.get(args[0]);
        //Path start = Paths.get(".");
        String ext = args[1];
        search(start, ext).forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> !p.toFile().getName().endsWith(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}