package syerraBeyts.glava_12.ex_425;

import javax.swing.*;
import java.awt.*;

/**
 * упражнение стр 426
 * @autor irinaff
 * @since 31.01.2017
 **/

public class Animate {
    int x = 1;
    int y = 1;
    public static void main (String[] args) {
        Animate gui = new Animate();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawP drawP = new MyDrawP();
        frame.getContentPane().add(drawP);
        frame.setSize(500,270);
        frame.setVisible(true);

        for (int i = 0; i < 124; i++, x++, y++) {
            x ++;
            drawP.repaint();
            frame.repaint();

            try {
                Thread.sleep(50);
            } catch (Exception e) {}
        }
    }

    class MyDrawP extends JPanel {
        public void paintComponent (Graphics g) {
            //Graphics2D g2 = (Graphics2D) g;
            g.setColor(Color.white);
            g.fillRect(0,0,500,250);
            g.setColor(Color.blue);
            g.fillRect(100,70,500-x*2,250-y*2);
        }
    }
}
