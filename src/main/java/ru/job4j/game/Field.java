package ru.job4j.game;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.StringJoiner;

public class Field {
    private int size = 3;
    private Figure[][] cells = new Figure[size][size];
    private Logic logic = new Logic(cells);

    private boolean checkState() {
        boolean gap = this.logic.hasGap();
        if (!gap) {
            System.out.println("Все поля запонены! Начните новую Игру!");
            //this.showAlert();
        }
        return gap;
    }

    public String drawField() {
        StringJoiner row = new StringJoiner(System.lineSeparator());
        StringBuilder string = new StringBuilder();
        for (var el : cells) {
            for (var subEl : el) {
                if (subEl.isMarkO()) {
                    string.append("O");
                } else if (subEl.isMarkX()) {
                    string.append("X");
                } else {
                    string.append("_");
                }
            }
            row.add(string.toString());
            string = new StringBuilder();
        }
        return row.toString();
    }

    private void checkWinner() {
        if (this.logic.isWinnerX()) {
            System.out.println("Победили Крестики! Начните новую Игру!");
            //this.showAlert();
        } else if (this.logic.isWinnerO()) {
            System.out.println("Победили Нолики! Начните новую Игру!");
            //this.showAlert();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Figure[][] getCells() {
        return cells;
    }

    public void setCells(Figure[][] cells) {
        this.cells = cells;
    }

    public void setCell (int[] coord) {
        boolean markChoice ;
        int coordY = coord[0];
        int coordX = coord[1];
        int mark = coord[2];
        if (mark == 1) {
            markChoice = true;
        }
        else {
            markChoice = false;
        }
        Figure f = new Figure();
        f.setMark(markChoice);
        this.cells[coordY][coordX] = f;
    }

    public Figure getCell(int i, int j){
        return cells[i][j];
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public static void main(String[] args) {
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
        System.out.println(field.drawField());
        int[] forTest = new int[] {0,0,0};
        field.setCell(forTest);
        System.out.println(field.drawField());
    }

}
