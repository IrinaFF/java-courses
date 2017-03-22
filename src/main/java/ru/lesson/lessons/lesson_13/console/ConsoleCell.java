package ru.lesson.lessons.lesson_13.console;

import ru.lesson.lessons.lesson_13.Cell;

import java.io.PrintStream;

/**
 * Консольная версия поведения клетки
 */
public class ConsoleCell implements Cell<PrintStream> {
    private boolean bomb;
    private boolean suggestBomp = false;
    private boolean suggestEmpty = false;

    public ConsoleCell(boolean bomb) {
        this.bomb = bomb;
    }
    /**
     * является ли это бомбой
     */
    @Override
    public boolean isBomb(){
        return this.bomb;
    }
    /**
     * пользователь предположил что это бомба
     */
    @Override
    public boolean isSuggestBomb(){
        return this.suggestBomp;
    }
    /**
     * пользователь предположил что это пустая клетка
     */
    @Override
    public boolean isSuggestEmpty(){
        return this.suggestEmpty;
    }
    /**
     * устанавливает пустую клетку
     */
    @Override
    public void suggestEmpty(){
        this.suggestEmpty = true;
    }

    /**
     * устанавливает бомбу
     */
    @Override
    public void suggestBomb(){
        this.suggestBomp = true;
    }
    /**
     * Рисует клетку
     * @param paint - на чем рисуем
     * @param real - рисовать реальное значение или что пользователь выбрал
     */
    @Override
    public void draw(PrintStream paint, boolean real){
        if (real) {
            if (this.isBomb()) {
                paint.print("[*]");
            } else {
                paint.print("[ ]");
            }
        }
        else {
            if (this.suggestBomp) {
                paint.print("[?]");
            } else
                if (this.suggestEmpty){
                    paint.print("[ ]");
                } else {
                    paint.print("[X]");
                }
        }
    }
}
