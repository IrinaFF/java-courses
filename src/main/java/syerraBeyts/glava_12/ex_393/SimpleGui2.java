package syerraBeyts.glava_12.ex_393;
import javax.swing.*;
/**
 * test JPanel
 * @autor irinaff
 * @since 30.01.2017
 **/

public class SimpleGui2 {
    public static void main (String [] args) {
        //создаем фрейм
        JFrame frame = new JFrame();
        //создаем виджет - кнопку и даем текст который будет на ней отображаться
        MyDrowPanel5 panel = new MyDrowPanel5();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
