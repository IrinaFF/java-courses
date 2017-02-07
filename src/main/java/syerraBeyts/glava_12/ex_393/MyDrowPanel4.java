package syerraBeyts.glava_12.ex_393;

import javax.swing.*;
import java.awt.*;

/**
 * овал закрашенный градиентом
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MyDrowPanel4 extends JPanel {
    public void paintComponent (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(
                //начальные точка и цвет
                70,70,Color.blue,
                //конечные
                150,150,Color.orange);
        //градиент виртуальной кисти
        g2d.setPaint(gradient);
        //закрасить овал кистью
        g2d.fillOval(70,70,100,100);
    }
}
