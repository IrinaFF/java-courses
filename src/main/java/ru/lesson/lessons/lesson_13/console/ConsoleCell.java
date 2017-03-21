package ru.lesson.lessons.lesson_13.console;

import ru.lesson.lessons.lesson_13.Cell;

import java.io.PrintStream;

/**
 * Created by IFatkullina on 21.03.2017.
 */
public class ConsoleCell implements Cell<PrintStream> {
    private boolean bomb;
    private boolean suggestBomp = false;
    private boolean suggestEmpty = false;
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
        return this.suggestBomp;
    }
    @Override
    public boolean suggestEmpty(){
        return this.suggestEmpty;
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

    }
}
