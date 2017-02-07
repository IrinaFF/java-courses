package syerraBeyts.glava_13.p_445;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * пример CheckBox
 * @autor irinaff
 * @since 01.02.2017
 **/

public class CheckBox1 implements ItemListener{
    JCheckBox check;

    public static void main(String [] args) {
        CheckBox1 gui = new CheckBox1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
         check = new JCheckBox("Goes to 11");
        check.addItemListener(this);

        frame.getContentPane().add(BorderLayout.NORTH, check);
        frame.setSize(350,300);
        frame.setVisible(true);
    }

    public void itemStateChanged(ItemEvent ev) {
        String onOrOff = "of";
        if (check.isSelected()) onOrOff = "on";
        System.out.println("Check box is " + onOrOff);
    }
}