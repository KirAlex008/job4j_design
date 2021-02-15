package ru.job4j.game;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FieldTest {

    @Test
    public void drawField() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(), new Figure(true, false)},
        };
        Logic logic = new Logic(table);
        Field field = new Field();
        field.setCells(table);
        field.setSize(3);
        field.setLogic(logic);
        String mem = field.drawField();
        assertThat(
                mem,
                is(String.format("X__" + System.lineSeparator() +
                        "_X_" + System.lineSeparator() +
                "__X"))
        );
    }
}
