package syerraBeyts.glava_12.ex_400;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * панель с кнопкой и виджетом для рисования
 *
 * @autor irinaff
 * @since 30.01.2017
 **/

public class SimpleGuiBAD implements ActionListener {
    JFrame frame;

    public static void main (String [] args) {
        SimpleGuiBAD b = new SimpleGuiBAD();
        b.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);
        MyDrowPanelBAD panel = new MyDrowPanelBAD();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }

}
