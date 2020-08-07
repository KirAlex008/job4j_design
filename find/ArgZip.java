package ru.job4j.find;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArgZip  {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() throws IOException {
        directory();
        exclude();
        output();
        return true;
    }
    public String toString() {
        String s = "";
        for (var el : args) {
            s = s + " " + el + " ";
        }
        return s;
    }

    public String directory() throws IOException {
        Path file = Paths.get(args[0].substring(3));
        System.out.println(args[0].substring(3));
        if (!Files.isDirectory(file)) {
            throw new IllegalArgumentException(String.format("Directory is not exist"));
        }
        return args[0].substring(3);
    }

    public String exclude() throws IOException {
        if (!args[1].substring(3).equals("xml") ) {
            throw new IllegalArgumentException(String.format("File extension of exclusion is not right"));
        }
        return args[1].substring(3);
    }

    public String output() throws IOException {
        if (!args[2].contains(".zip")) {
            throw new IllegalArgumentException(String.format("File extension of archive file is not right"));
        }
        return args[2].substring(3);
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        String ext = "";
        ArgZip argZip = new ArgZip(args);
        for (var el : argZip.args) {
            System.out.println(el);
        }
        var el = argZip.directory();
        System.out.println(el);
    }
}