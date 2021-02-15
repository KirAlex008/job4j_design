package ru.job4j.game;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {
    @Test
    public void whenHasXWinner() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(), new Figure(true, false)},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerX(), is(true));
    }


    @Test
    public void whenNotFill() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerX(), is(false));
        //assertThat(login.isWinnerX(), is(false));
    }

    @Test
    public void whenHasXHorizontalWinner() {
        Figure[][] table = {
                {new Figure(), new Figure(), new Figure()},
                {new Figure(true, false), new Figure(true, false), new Figure(true, false)},
                {new Figure(), new Figure(), new Figure()},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXVerticalWinner() {
        Figure[][] table = {
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasXBackDiagonalWinner() {
        Figure[][] table = {
                {new Figure(), new Figure(), new Figure(true, false)},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(true, false), new Figure(), new Figure()},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerX(), is(true));
    }

    @Test
    public void whenHasOWinner() {
        Figure[][] table = {
                {new Figure(false, true), new Figure(), new Figure()},
                {new Figure(false, true), new Figure(false, true), new Figure()},
                {new Figure(false, true), new Figure(), new Figure(false, true)},
        };
        Logic login = new Logic(table);
        assertThat(login.isWinnerO(), is(true));
    }

    @Test
    public void whenHasGas() {
        Figure[][] table = {
                {new Figure(true, false), new Figure(), new Figure()},
                {new Figure(), new Figure(true, false), new Figure()},
                {new Figure(), new Figure(), new Figure(true, false)},
        };
        Logic login = new Logic(table);
        assertThat(login.hasGap(), is(true));
    }

}