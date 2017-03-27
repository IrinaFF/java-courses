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
        System.out.println("shouldBang: " + (selected.isBomb() && !selected.isSuggestBomb()));
        return selected.isBomb() && !selected.isSuggestBomb();
    }
    /**
     * разгадал ли пользователь все поле
     */
    @Override
    public boolean finish(){
        System.out.println("SaperLogic.finish");
        boolean finish = true;
        boolean finish1 = false;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                finish1 = ((cell.isSuggestBomb() && cell.isBomb() ||
                        (cell.isSuggestEmpty() && !cell.isBomb())));
                //System.out.println("isBomb=" + cell.isBomb()+" finish1 =" + finish1 );
                finish &= finish1;
            }
        }

        System.out.println("finish: " + finish);
        return finish;
    }
    /**
     * событие которое приходит от пользователя
     */
    @Override
    public void suggest(int x, int y, boolean bomb){
        System.out.println("2.Easy.suggest: x="+x+" y="+y+" "+bomb);
        if (bomb) {
            this.cells[x][y].suggestBomb();
        }
        else {
            this.cells[x][y].suggestEmpty();
        }
    }
}
