package ru.lesson.lessons.lesson_13;

/**
 * Описывает действия пользователя
 */
public interface UserAction {
    /**
     * инициализация игры
     */
    void initGame();
    /**
     * действие пользователя
     */
    void select(int x, int y, boolean bomb);
}

