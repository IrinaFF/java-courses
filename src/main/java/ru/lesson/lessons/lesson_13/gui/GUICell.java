package ru.lesson.lessons.lesson_13.gui;

import ru.lesson.lessons.lesson_13.Cell;

import java.awt.*;

/**
 * Графическая версия поведения клетки
 **/

public class GUICell implements Cell<Graphics> {
    private boolean bomb;
    private boolean suggestBomp = false;
    private boolean suggestEmpty = false;
    public static final int PADDING = 50;

    public GUICell(boolean bomb) {
        this.bomb = bomb;
    }
    /**
     * является ли это бомбой
     */
    public boolean isBomb() { return this.bomb; }
    /**
     * пользователь предположил что это бомба
     */
    public boolean isSuggestBomb() { return this.suggestBomp; }

    /**
     * пользователь предположил что это пустая клетка
     */
    public boolean isSuggestEmpty() { return this.suggestEmpty; }
    /**
     * устанавливает пустую клетку
     */
    public void suggestEmpty() {
        this.suggestEmpty = true;
    }
    /**
     * устанавливает бомбу
     */
    public void suggestBomb() {
        this.suggestBomp = true;
        System.out.println("3. GUICell.suggestBomb");
    }
    /**
     * Рисует клетку
     * @param paint - на чем рисуем
     * @param real - рисовать реальное значение или что пользователь выбрал
     */
    public void draw(Graphics paint, boolean real) {
        //paint.
        System.out.println("GUICell.draw");
        if (real) {
            if (this.isBomb()) {
                System.out.println("[*]");
                paint.setColor(Color.red);
                //paint.drawRect(x * PADDING, y * PADDING, PADDING, PADDING);
            } else {
                System.out.println("[ ]");
                paint.setColor(Color.green);
            }
        }
        else {
            if (this.suggestBomp) {
                System.out.println("[?]");
                paint.setColor(Color.yellow);
            } else
            if (this.suggestEmpty){
                System.out.println("[ ]");
                paint.setColor(Color.blue);
            } else {
                System.out.println("[X]");
                paint.setColor(Color.darkGray);
            }
        }
    }
}
