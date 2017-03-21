package ru.lesson.lessons.lesson_13;

/**
 * Описывает поведение доски
 */
public interface Cell<T> {
    /**
     * является ли это бомбой
     */
    boolean isBomb();
    /**
     * пользователь предположил что это бомба
     */
    boolean isSuggestEmpty();
    /**
     * пользователь предположил что это пустая клетка
     */
    boolean suggestEmpty();
    /**
     * устанавливает бомбу
     */
    void suggestBomb();
    /**
     * Рисует клетку
     * @param paint - на чем рисуем
     * @param real - рисовать реальное значение или что пользователь выбрал
     */
    void draw(T paint, boolean real);
}
