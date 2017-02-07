package syerraBeyts.glava_12.ex_393;

import javax.swing.*;
import java.awt.*;

/**
 * личный виджет для рисования
 * создание собственной графики - JPEG
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MyDrowPanel2 extends JPanel {
    //метод будет вызываться только системой
    public void paintComponent (Graphics g) {
        Image image = new ImageIcon("D:\\cat1.jpg").getImage();
        g.drawImage(image,3,4,this);
    }
}
