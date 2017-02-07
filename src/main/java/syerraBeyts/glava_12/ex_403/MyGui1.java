package syerraBeyts.glava_12.ex_403;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * регистрируем одного слушателя для обеих кнопок
 * способ первый, рабочий
 * но один метод на все события - обычно плохое решение
 * @autor irinaff
 * @since 31.01.2017
 **/

public class MyGui1 implements ActionListener {
    //объявляем поля
    JFrame frame;
    JButton colorButton;
    JButton labelButton;

    public void go() {
        //создаем gui
        colorButton = new JButton();
        labelButton = new JButton();
        //регистрируем одного слушателя для обеих кнопок
        colorButton.addActionListener(this);
        labelButton.addActionListener(this);
        //графический код

    }
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == colorButton) {
            frame.repaint();
        } else {
            labelButton.setText("Больно!");
        }
    }
}
