package ru.lesson.lessons.lesson_13.console;

import ru.lesson.lessons.lesson_13.Board;
import ru.lesson.lessons.lesson_13.Cell;

/**
 * Консольная версия поведения доски
 */
public class ConsoleBoard implements Board {
    //поле с картой
    private Cell[][] cells;

    /**
     * рисует доску исходя из входящего массива ячеек
     */
    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        this.redraw(false);
    }

    /**
     * рисует ячейку
     * @param x позиция по горизонтали
     * @param y позиция по вертикали
     */
    public void drawCell(int x, int y) {
        System.out.println("***** SELECT *****");
        this.redraw(false);
    }
    /**
     * рисует взрыв сех бомб
     */
    public void drawBang() {
        System.out.println("***** BANG *****");
        this.redraw(true);
    }

    /**
     * рисует поздравления когда игра выиграна
     */
    public void drawCongratulate() {
        System.out.println("***** CONGRATULATE *****");
    }

    private void redraw(boolean real) {
       for (Cell[] row: cells) {
           for (Cell cell : row) {
                cell.draw(System.out, real);
           }
           System.out.println();
       }
        System.out.println();
    }
}
