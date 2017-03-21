package ru.lesson.lessons.lesson_13;

/**
 * Описывает логику
 */
public interface SaperLogic {
    /**
     * загружаем поле на котором будем делать вычисления
     */
    void loadBoard(Cell[][] cells);
    /**
     * проверяем нужен ли взрыв
     */
    boolean shouldBang(int x, int y);
    /**
     * разгадал ли пользователь все поле
     */
    boolean finish();
    /**
     * событие которое приходит от пользователя
     */
    void suggest(int x, int y, boolean bomb);
}
