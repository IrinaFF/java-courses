package syerraBeyts.glava_12.ex_393;
import javax.swing.*;
import java.awt.*;
/**
 * личный виджет для рисования
 * создание собственной графики - круг произвольного цвета на черном фоне
 * @autor irinaff
 * @since 30.01.2017
 **/

public class MyDrowPanel3 extends JPanel {
    public void paintComponent (Graphics g) {
        //закраисм панель ченрым цветом(по умолчанию)
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70,70,100,100);
    }
}
