package ru.job4j.game;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FigureTest {
    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new Figure(false,true).print(out);
        assertThat(out.toString(), is("O"));
    }

    @Test
    public void printMarkO() {
    ByteArrayOutputStream mem = new ByteArrayOutputStream();
    PrintStream out = System.out;
    System.setOut(new PrintStream(mem));
    new Figure(false,true).printMark();
    assertThat(
            mem.toString(),
    is(String.format("O"))
            );
        System.setOut(out);
    }
}