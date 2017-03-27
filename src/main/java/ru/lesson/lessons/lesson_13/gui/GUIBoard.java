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
        System.out.println("GUIBoard.paintComponent");
        graphics.fillRect (0, 0, this.getWidth () , this.getHeight ()) ;

        Graphics gr;
        gr = getGraphics(); //получаем графический контекст

        if (this.cells != null) {
            for (int x = 0; x != cells.length; x++ ) {
                for (int y = 0; y != cells[0].length; y++ ) {
                    System.out.println("x="+x+" y="+y + ", isBomb=" + cells[x][y].isBomb());
                    graphics.setColor(Color.black);

                    graphics.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
                    graphics.setColor(Color.gray);
                    graphics.fillRect((x * PADDING)+2, (y * PADDING)+2, PADDING-4, PADDING-4);

                    gr.translate((x * PADDING) + PADDING/2, (y * PADDING) + PADDING/2);
                    cells[x][y].draw(gr, false);
                    //graphics.drawString("x="+x+" y="+y, (x* PADDING)+10,(y* PADDING)+10);
                    //graphics.drawString(Boolean.toString(cells[x][y].isBomb()), (x* PADDING)+10,(y* PADDING)+20);
                }
            }
        } else {
            System.out.println("this.cells = null");
        }

    }

    /**
     * рисует доску исходя из входящего массива ячеек
     */
    public void drawBoard(Cell[][] cells){
        System.out.println("GUIBoard.drawBoard");
        this.cells = cells;
        this.repaint();
    }

    /**
     * рисует ячейку
     * @param x позиция по горизонтали
     * @param y позиция по вертикали
     */
    public void drawCell(int x, int y){
        //System.out.println("***** SELECT *****");
        System.out.println("4. GUIBoard.drawCell");
        Graphics gr;
        gr = getGraphics(); //получаем графический контекст

        if (this.cells != null) {
            //gr.setColor(Color.red);
            gr.translate(x * PADDING, y * PADDING);
            //this.repaint();
            cells[x][y].draw(gr, false);
        }
    }
    /**
     * рисует взрыв всех бомб
     */
    public void drawBang(){
        System.out.println("***** BANG *****");
        //System.out.println("GUIBoard.drawBang");
        Graphics gr;
        gr = getGraphics(); //получаем графический контекст
        if (this.cells != null) {
            for (int x = 0; x != cells.length; x++ ) {
                for (int y = 0; y != cells[0].length; y++ ) {
                    System.out.println("x="+x+" y="+y + ", isBomb=" + cells[x][y].isBomb());
                    gr.setColor(Color.red);
                    cells[x][y].draw(gr, true);
                    //gr.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
                }
            }
        }
        this.repaint();
    }

    /**
     * рисует поздравления когда игра выиграна
     */
    public void drawCongratulate(){
        //System.out.println("***** CONGRATULATE *****");
        System.out.println("GUIBoard.drawCongratulate");
    }

    private void redraw(boolean real) {
        System.out.println("GUIBoard.redraw");
        for (Cell[] row: cells) {
            for (Cell cell : row) {
                cell.draw(System.out, real);
            }
            System.out.println();
        }
        System.out.println();
    }
}
