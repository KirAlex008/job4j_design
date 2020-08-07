package ru.job4j.generics;

import ru.job4j.find.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) throws IOException {
        for (var source : sources) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                zip.putNextEntry(new ZipEntry(source.toFile().getName()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void packSingleFile(Path source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getName()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Path> listForArchiv (Path root) {
        List<Path> pathList = new ArrayList<>();
        if (!root.toFile().exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", root.toFile().getAbsoluteFile()));
        }
        if (!root.toFile().isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", root.toFile().getAbsoluteFile()));
        }
        for (File subfile : root.toFile().listFiles()) {
            pathList.add(Paths.get(subfile.getAbsoluteFile().toString()));
        }
        return pathList;
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext)) ;
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void main(String[] args) throws IOException {

        Path sources = Paths.get("./src/main/java/ru/job4j/find/");
        File target = new File("find.zip");

        List<Path> pathList = Zip.listForArchiv(sources);
        for (Path subfile : pathList) {
            System.out.println(subfile.toFile().getAbsoluteFile());
        }

        Zip zipper = new Zip();
        zipper.packFiles(pathList, target);

    }
}