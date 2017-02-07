package syerraBeyts.glava_13.p_434;

import javax.swing.*;
import java.awt.*;
/**
 * компоновка FlowLayout
 * @autor irinaff
 * @since 01.02.2017
 **/

public class Panel1 {
    public static void main (String [] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        //сделаем панель серой, чтобы различить на фоне фрейма
        panel.setBackground(Color.darkGray);

        //диспетчер компоновки Flow контролирует кнопку
        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonTree = new JButton("huh?");
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonTree);
        //panel.setSize(frame.getWidth(),frame.getHeight());
        //а диспетчер компоновки Border управляет панелью
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}
