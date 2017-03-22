package ru.lesson.lessons.lesson_13.gui;

import ru.lesson.lessons.lesson_13.Board;
import ru.lesson.lessons.lesson_13.Cell;

import javax.swing.*;
import java.awt.*;

/**
 * Графическая версия поведения доски
 **/

public class GUIBoard extends JPanel implements Board{
    public static final int PADDING = 50;
    public Cell<Graphics>[][] cells;

    //метод рисования
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        if (this.cells != null) {
            for (int x = 0; x != cells.length; x++ ) {
                for (int y = 0; y != cells[0].length; y++ ) {
                    graphics.setColor(Color.black);
                    cells[x][y].draw(graphics, false);
                    graphics.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
                }
            }
        }
    }

    /**
     * рисует доску исходя из входящего массива ячеек
     */
    public void drawBoard(Cell[][] cells){
        this.cells = cells;
        this.repaint();
    }

    /**
     * рисует ячейку
     * @param x позиция по горизонтали
     * @param y позиция по вертикали
     */
    public void drawCell(int x, int y){
        System.out.println("***** SELECT *****");
        this.repaint();
    }
    /**
     * рисует взрыв сех бомб
     */
    public void drawBang(){
        System.out.println("***** BANG *****");
        this.repaint();
    }

    /**
     * рисует поздравления когда игра выиграна
     */
    public void drawCongratulate(){
        System.out.println("***** CONGRATULATE *****");
    }
}
