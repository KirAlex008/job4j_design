package ru.job4j.game;

import java.util.List;

public class PlayerMan implements Player {

    public PlayerMan(int mark) {
        this.mark = mark;
    }

    private int mark;

    @Override
    public int[] choiceCell(Input input) {
        int[] coord = new int[3];
        coord[0] = input.getNumber("Select Y: ");
        coord[1] = input.getNumber("Select X: ");
        coord[2] = mark;
        return coord;
    }

/*    public boolean moveIsRight(Field field) {

    }*/

    @Override
    public void move(Field field, Input input) {
        int[] rsl = choiceCell(input);
        Figure figure = field.getCell(rsl[0], rsl[1]);
        if (figure.hasMarkX() == false && figure.hasMarkO() == false) { // возможно лучше цикл while, пока ход не завершился успехом
            // соответственно тест move должен содержать оба варианта возможных исходов
            field.setCell(rsl);
            for (var el : rsl) {
                System.out.println(el);
            }
        } else {
            System.out.println("X or Y have error");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        //int[] forTest = new int[] {0,0,1};
        PlayerMan player1 = new PlayerMan(1);
        //int[] rsl = player1.choiceCell(input);
        /*for (var el : rsl) {
            System.out.println(el);
        }*/
        Figure[][] table = {
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
                {new Figure(), new Figure(), new Figure()},
        };
        Logic logic = new Logic(table);
        Logic logicForTest = new Logic(table);

        Field field = new Field();
        field.setCells(table);
        field.setSize(3);
        field.setLogic(logic);
        player1.move(field, input);
    }
}
