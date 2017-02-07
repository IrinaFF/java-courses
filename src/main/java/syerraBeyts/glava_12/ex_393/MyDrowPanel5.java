package syerraBeyts.glava_12.ex_393;

import javax.swing.*;
import java.awt.*;

/**
 * овал закрашенный градиентом
 * цвета выбираются произвольно
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MyDrowPanel5 extends JPanel {

    public void paintComponent (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(
                //начальные точка и цвет
                70,70,startColor,
                //конечные
                150,150,endColor);
        //градиент виртуальной кисти
        g2d.setPaint(gradient);
        //закрасить овал кистью
        g2d.fillOval(70,70,100,100);
    }
}
