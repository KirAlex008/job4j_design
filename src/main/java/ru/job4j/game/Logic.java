package ru.job4j.game;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic {
    private final Figure[][] table;

    public Logic(Figure[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean isWinX(Predicate<Figure> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0) ||
                this.fillBy(predicate, 0, 0, 0, 1) ||
                this.fillBy(predicate, 0,0, 1, 1) ||
                this.fillBy(predicate, this.table.length - 1 , 0, -1, 1) ||
                this.fillBy(predicate, 0,this.table.length - 2, 1, 0) ||
                this.fillBy(predicate, 0,this.table.length - 1, 1, 0) ||
                this.fillBy(predicate, this.table.length - 2,0, 0, 1) ||
                this.fillBy(predicate, this.table.length - 1,0, 0, 1);
    }

    public boolean isWinnerX() {
        return isWinX(Figure::hasMarkX);
    }

    public boolean isWinnerO() {

        return isWinX(Figure::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(el -> (el.hasMarkX() && el.hasMarkO()) == false);
    }
}
