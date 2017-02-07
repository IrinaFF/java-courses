package syerraBeyts.glava_12.ex_413;
import javax.swing.*;
import java.awt.*;
/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 31.01.2017
 **/

public class MyOvalAnumation {
    JFrame frame;
    int x;
    int y;

    public static void main (String[] args) {
        MyOvalAnumation a = new MyOvalAnumation();
        a.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        MyDrowPanel panel = new MyDrowPanel();
        frame.getContentPane().add(panel);
        frame.setVisible(true);

        x = 20;
        y = 20;
        while ((x < 200) && (y < 200)) {
            x ++;
            y ++;
            panel.repaint();
            frame.repaint();
            try {
                Thread.sleep(10);
            }
            catch (Exception ex) {}
        }
    }

    //создаем наследника JPanel - графический виджет
    public class MyDrowPanel extends JPanel {
        //метод будет вызываться только системой
        public void paintComponent(Graphics g) {
            //сообщаем цвет
            g.setColor(Color.orange);
            //сообщаем координаты местоположения и размеры фигуры
            g.fillOval(x, y, 30,30);

        }
    }
}

