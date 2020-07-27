package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

public class AnalizyForTestTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        List<String> strArr = new ArrayList<>();
        try (BufferedReader out = new BufferedReader(new FileReader("server.log"))) {
            String line;
            while ((line = out.readLine()) != null) {
                strArr.add(line + System.lineSeparator());
            }
        }
        try (BufferedWriter in = new BufferedWriter(new FileWriter(source))) {
            for (var el : strArr) {
                in.write(el);
            }
        }

        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
            read.lines().forEach(out::add);
        }
        String forTest = "10:58:01;10:59:01" + System.lineSeparator() + "11:01:02;11:02:02";
        assertThat(
                out.toString(),
                is(forTest)
        );
    }

}