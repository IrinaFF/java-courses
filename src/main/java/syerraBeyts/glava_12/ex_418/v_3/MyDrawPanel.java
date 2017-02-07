package syerraBeyts.glava_12.ex_418.v_3;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

/**
 * панель для рисвования - слушатель
 * @autor irinaff
 * @since 31.01.2017
 **/

//нам нужно отслеживать события ControllerEvent
public class MyDrawPanel extends JPanel implements ControllerEventListener {
    //будем присваивать флагу true когда получим событие
    boolean msg = false;

    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }

    public void paintComponent(Graphics g) {
        //рисуем только когда получаем событие ControllerEvent
        if (msg) {
            Graphics2D g2 = (Graphics2D) g;
            //генерация случайного цвета
            int r = (int) (Math.random() * 250);
            int gr = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

            g.setColor(new Color(r,gr,b));

            //рисование полупроизвольного прямоугольника
            //высота и ширина
            int ht = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            //координаты
            int x= (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);

            g.fillRect(x,y,ht,width);
            msg = false;
        }
    }
}
