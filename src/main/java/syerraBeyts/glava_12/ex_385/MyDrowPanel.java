package syerraBeyts.glava_12.ex_385;
import javax.swing.*;
import java.awt.*;
/**
 * личный виджет для рисования
 * создание собственной графики - квадрат
 * @autor irinaff
 * @since 30.01.2017
 **/

//создаем наследника JPanel - графический виджет
public class MyDrowPanel extends JPanel {
    //метод будет вызываться только системой
    public void paintComponent (Graphics g) {
        //сообщаем цвет
        g.setColor(Color.orange);
        //сообщаем координаты местоположения и размеры фигуры
        g.fillRect(20,50,100,100);

    }
}
