package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void unavailable() {
        Analizy analizy = new Analizy();
        File file = new File("unavailable.csv");
        file.delete();
        analizy.unavailable("server.log", "unavailable.csv");
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader("unavailable.csv"))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String forTest = "10:58:01;10:59:01" + System.lineSeparator() + "11:01:02;11:02:02";
        assertThat(
                out.toString(),
                is(forTest)
        );
    }
}