package syerraBeyts.glava_13.p_434;

import javax.swing.*;
import java.awt.*;
/**
 * компоновка BoxLayout
 * @autor irinaff
 * @since 01.02.2017
 **/

public class Panel2 {
    public static void main (String [] args) {
        Panel2 gui = new Panel2();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("frame");
        JPanel panel = new JPanel();
        //сделаем панель серой, чтобы различить на фоне фрейма
        panel.setBackground(Color.darkGray);

        //изменяем диспетчер компоновки на новый
        //указываем ось для вертикального расположения
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        //диспетчер компоновки Flow контролирует кнопку
        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonTree = new JButton("huh?");
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonTree);
        //а диспетчер компоновки Border управляет панелью
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250,200);
        frame.setVisible(true);
    }
}
