package ru.lesson.lessons.lesson_13.logics;

import ru.lesson.lessons.lesson_13.Cell;
import ru.lesson.lessons.lesson_13.SaperLogic;

/**
 * простая логика
 **/

public class Easy implements SaperLogic {
    //поле с картой
    private Cell[][] cells;

    /**
     * загружаем поле на котором будем делать вычисления
     */
    @Override
    public void loadBoard(Cell[][] cells){
        this.cells = cells;
    }
    /**
     * проверяем нужен ли взрыв
     */
    @Override
    public boolean shouldBang(int x, int y){
        final Cell selected = this.cells[x][y];
        return selected.isBomb() && !selected.isSuggestBomb();
    }
    /**
     * разгадал ли пользователь все поле
     */
    @Override
    public boolean finish(){
        boolean finish = false;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                finish = ((cell.isSuggestBomb() && cell.isBomb() ||
                        (cell.isSuggestEmpty() && !cell.isBomb())));
            }
        }
        return finish;
    }
    /**
     * событие которое приходит от пользователя
     */
    @Override
    public void suggest(int x, int y, boolean bomb){
        if (bomb) {
            this.cells[x][y].suggestBomb();
        }
        else {
            this.cells[x][y].suggestEmpty();
        }
    }
}
