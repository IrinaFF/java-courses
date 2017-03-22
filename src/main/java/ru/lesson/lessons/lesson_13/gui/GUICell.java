package ru.lesson.lessons.lesson_13.gui;

import ru.lesson.lessons.lesson_13.Cell;

import java.awt.*;

/**
 * Графическая версия поведения клетки
 **/

public class GUICell implements Cell<Graphics> {

    /**
     * является ли это бомбой
     */
    public boolean isBomb() { return false; }
    /**
     * пользователь предположил что это бомба
     */
    public boolean isSuggestBomb() { return false; }

    /**
     * пользователь предположил что это пустая клетка
     */
    public boolean isSuggestEmpty() { return false; }
    /**
     * устанавливает пустую клетку
     */
    public void suggestEmpty() {

    }
    /**
     * устанавливает бомбу
     */
    public void suggestBomb() {

    }
    /**
     * Рисует клетку
     * @param paint - на чем рисуем
     * @param real - рисовать реальное значение или что пользователь выбрал
     */
    public void draw(Graphics paint, boolean real) {
        //paint.
    }
}
