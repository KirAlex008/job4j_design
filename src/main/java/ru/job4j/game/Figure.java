package ru.job4j.game;

import java.io.IOException;
import java.io.OutputStream;

public class Figure implements Mark<OutputStream> {
    private boolean markX = false;
    private boolean markO = false;

    public Figure() {
    }

    public Figure(boolean markX, boolean markO) {
        this.markX = markX;
        this.markO = markO;
    }

    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean hasMarkX() {
        return this.markX;
    }

    public boolean hasMarkO() {
        return this.markO;
    }

    @Override
    public void print(OutputStream screen) {
        if (this.markX == true) {
            try {
                screen.write("X".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.markO == true) {
            try {
                screen.write("O".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void printMark() {
        if (this.markX) {
            System.out.print("X");
        }
        if (this.markO) {
            System.out.print("O");
        } else {
            System.out.println("_");
        }
    }

    public boolean isMarkX() {
        return markX;
    }

    public void setMark(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    public boolean isMarkO() {
        return markO;
    }

    public void setMarkO(boolean markO) {
        this.markO = markO;
    }

    /*public static void main(String[] args) {
        Figure figure = new Figure(false,true);
        figure.printMark();
    }*/
}
