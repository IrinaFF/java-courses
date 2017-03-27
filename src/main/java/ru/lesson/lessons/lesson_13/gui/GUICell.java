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
    private boolean isSelect = false;
    public static final int PADDING = 25;
    private int x = 0;
    private int y = 0;

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
        Color oldColor = paint.getColor();
        System.out.println("GUICell.draw");
        if (real) {
            if (this.isBomb()) {
                System.out.println("[*]");
                paint.setColor(Color.red);
            } else {
                System.out.println("[ ]");
                paint.setColor(Color.green);
            }
        }
        else {
            if (this.suggestBomp) {
                System.out.println("ORANGE [?]");
                paint.setColor(Color.ORANGE);
            } else
            if (this.suggestEmpty){
                System.out.println("darkGray [ ]");
                paint.setColor(Color.darkGray);
            } else {
                System.out.println("gray [X]");
                paint.setColor(Color.gray);

            }
        }
        paint.fillOval(PADDING/2, PADDING/2, PADDING, PADDING);
        paint.setColor(oldColor);
    }
}
