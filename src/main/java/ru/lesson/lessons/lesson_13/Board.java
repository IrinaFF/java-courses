package ru.lesson.lessons.lesson_13;

/**
 * Описывает поведение доски
 */
public interface Board {
    /**
     * рисует доску исходя из входящего массива ячеек
     */
    void drawBoard(Cell[][] cells);

    /**
     * рисует ячейку
     * @param x позиция по горизонтали
     * @param y позиция по вертикали
     */
    void drawCell(int x, int y);
    /**
     * рисует взрыв сех бомб
     */
    void drowBang();

    /**
     * рисует поздравления когда игра выиграна
     */
    void drawCongratulate();
}
