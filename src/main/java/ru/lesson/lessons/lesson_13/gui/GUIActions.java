package ru.lesson.lessons.lesson_13.gui;

import ru.lesson.lessons.lesson_13.BaseAction;
import ru.lesson.lessons.lesson_13.Board;
import ru.lesson.lessons.lesson_13.GeneratorBoard;
import ru.lesson.lessons.lesson_13.SaperLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Реализация поведения пользователя
 **/

public class GUIActions extends BaseAction implements ActionListener, MouseListener {

    private GUIBoard board;
    private SaperLogic logic;
    private GeneratorBoard generator;

    public GUIActions(SaperLogic logic, GUIBoard board, GeneratorBoard generator) {
        super(logic, board, generator);
        this.board = board;
        this.logic = logic;
        this.generator = generator;
        this.board.addMouseListener(this);
    }

    public void actionPerformed (ActionEvent e) {
        this.initGame();
    }

    //выполнен щелчок мышкой на наблюдаемом объекте
    public void mouseClicked(MouseEvent e) {
        System.out.println("0. GUIActions.mouseClicked");
        int x = 0;
        int y = 0;
        boolean bomb = false;
        if (e.getX() > 50) x = 1;
        if (e.getY() > 50) y = 1;
        if (e.getButton() == 1) {
            bomb = false;
        }
        else if (e.getButton() == 3) {
            bomb = true;
        }
        else return;
        //System.out.println("getButton: " + e.getButton());
        this.select(x,y,bomb);
        //board.repaint();
    }

    //кнопка мыши нажата в момент, когда курсор находится над наблюдаемым объектом
    public void mousePressed(MouseEvent e) {

    }

    //кнопка мыши отпущена в момент, когда курсор находится над наблюдаемым объектом
    public void mouseReleased(MouseEvent e) {

    }

    //курсор мыши вошел в область наблюдаемого объекта
    public void mouseEntered(MouseEvent e) {

    }

    //курсор мыши вышел из области наблюдаемого объекта
    public void mouseExited(MouseEvent e) {

    }
}
