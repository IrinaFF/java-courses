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

    public void mouseClicked(MouseEvent e) {
        int x = 0;
        int y = 0;
        boolean bomb = false;
        if (e.getX() > 50) x = 1;
        if (e.getY() > 50) y = 1;
        if (e.getClickCount() > 1) bomb = true;
        this.select(x,y,bomb);
        board.repaint();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
