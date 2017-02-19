package syerraBeyts.glava_18.p_669;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 * Created by Irina on 10.02.2017.
 * (универсальный сервис, реализует Service)
 */
public class DayOfTheWeekService implements Service {
    JLabel outputLabel;
    JComboBox month;
    JTextField day;
    JTextField year;

    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Do it!");
        button.addActionListener(new DoItListener());
        outputLabel = new JLabel("date appears here");
        DateFormatSymbols dateStuff = new DateFormatSymbols();
        month = new JComboBox(dateStuff.getMonths());
        day = new JTextField(8);
        year = new JTextField(8);
        JPanel inputPanel = new JPanel(new GridLayout(3,2));
        inputPanel.add(new JLabel("Month"));
        inputPanel.add(month);
        inputPanel.add(new JLabel("Day"));
        inputPanel.add(day);
        inputPanel.add(new JLabel("Year"));
        inputPanel.add(year);
        panel.add(inputPanel);
        panel.add(button);
        panel.add(outputLabel);
        return panel;
    }

    public class DoItListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            int monthNum = month.getSelectedIndex();
            int dayNum = Integer.parseInt(day.getText());
            int yearNum = Integer.parseInt(year.getText());

            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH, monthNum);
            c.set(Calendar.YEAR, yearNum);
            Date date = c.getTime();
            String dayOfWeek = (new SimpleDateFormat("EEEE")).format(date);
            System.out.println("DayOfTheWeekService, dayOfWeek=" + dayOfWeek);
            outputLabel.setText(dayOfWeek);
            System.out.println("DayOfTheWeekService.DoItListener.actionPerformed");
        }
    }
}
