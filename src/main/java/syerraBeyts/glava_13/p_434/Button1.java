package syerraBeyts.glava_13.p_434;

import javafx.scene.text.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Font;

/**
 * компоновка BorderLayout
 * @autor irinaff
 * @since 01.02.2017
 **/

public class Button1 {

    public static void main (String [] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        //JButton button = new JButton("click me");
        //JButton button = new JButton("click like you mean it");
        //JButton button = new JButton("There is no spoon...");
        //JButton button = new JButton("Click This!");
        //Font bigFont = new Font("serif", Font.BOLD, 28);
        //button.setFont(bigFont);
        //frame.getContentPane().add(BorderLayout.EAST, button);
        //frame.getContentPane().add(BorderLayout.NORTH, button);

        JButton east = new JButton("east");
        JButton west = new JButton("west");
        JButton north = new JButton("north");
        JButton south = new JButton("south");
        JButton center = new JButton("center");

        frame.getContentPane().add(BorderLayout.EAST, east);
        frame.getContentPane().add(BorderLayout.WEST, west);
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.SOUTH, south);
        frame.getContentPane().add(BorderLayout.CENTER, center);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
