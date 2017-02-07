package syerraBeyts.glava_12.ex_409;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * способ 4 рабочий
 * рабочий код с двумя кнопками
 * 4 объекта: 2 кнопки, виджет для рисования, метка
 * @autor irinaff
 * @since 31.01.2017
 **/
//главный gui класс не реализует интерфейс
public class TwoButtons {
    JFrame frame;
    JLabel label;

    public static void main (String [] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JButton labelButton = new JButton("Change label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm label");
        MyDrowPanelBAD drawpanel = new MyDrowPanelBAD();

        frame.getContentPane().add(BorderLayout.CENTER, drawpanel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);

        frame.setSize(600,600);
        frame.setVisible(true);
    }

    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!");
        };
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        };
    }
}
