package syerraBeyts.glava_12.ex_413;

import javax.swing.*;
import java.awt.*;

/**
 * полный код для вывода просстой анимции
 * @autor irinaff
 * @since 31.01.2017
 **/

public class SimpleAnimation {
    //в главном классе gui создаем два поля для координат круга
    int x = 70;
    int y = 70;

    public static void main (String [] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrowPanel drowPanel = new MyDrowPanel();
        frame.getContentPane().add(drowPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        //повторяем 130 раз
        for (int i=0; i < 130; i++) {
            x++;
            y++;
            //перерисовать круг на новом месте
            drowPanel.repaint();

            //немного замедляем процесс
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
        }

    }

    //теперь он стал внутренним классом
    class MyDrowPanel extends JPanel {
        public void paintComponent (Graphics g) {
            //перед прорисовкой круга закрасим всю панель рисования в белый цвет
            //выбрали цвет
            g.setColor(Color.white);
            //нарисовали квадрат
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            //нарисуем зеленый круг
            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
        }
    }
}
