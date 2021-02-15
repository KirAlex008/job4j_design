package ru.job4j.game;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class PlayerManTest {

    @Test
    public void testMove() {
        Input input = new ConsoleInput();
        Figure[][] table = {
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
        };
        Figure[][] tableForTest = {
                {new Figure(true,false), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
        };
        Logic logic = new Logic(table);
        Logic logicForTest = new Logic(table);

        Field field = new Field();
        field.setCells(table);
        field.setSize(3);
        field.setLogic(logic);

        Field fieldForTest = new Field();
        field.setCells(tableForTest);
        field.setSize(3);
        field.setLogic(logicForTest);

        PlayerMan player1 = new PlayerMan(1);
        System.out.println("Test");
        player1.move(field, input);
        //player1.choiceCell(input);

        assertThat(field, is(fieldForTest));
    }

    /*@Test
    public void testChoiceCell() {
        //Input input = new ValidateInput();
        Input input = new ConsoleInput();
        int[] forTest = new int[] {0,0,1};
        PlayerMan player1 = new PlayerMan(1);
        int[] rsl = player1.choiceCell(input);
        assertThat(rsl, is(forTest));
    }*/
}