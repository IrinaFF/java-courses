package syerraBeyts.glava_18.p_669;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Irina on 10.02.2017.
 * (универсальный сервис, реализует Service)
 */
public class DiceService implements Service {

    JLabel label;
    JComboBox numOfDice;

    //вызывается когда сервис выбирают из списка и загружают
    public JPanel getGuiPanel() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Roll em!");
        String [] choices = {"1", "2", "3", "4", "5"};
        numOfDice = new JComboBox(choices);
        label = new JLabel("dice values here");
        button.addActionListener(new RollEmListener());
        panel.add(numOfDice);
        panel.add(button);
        panel.add(label);
        return panel;
    }

    public class RollEmListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            //бросаем кости
            String diceOutput = "";
            String selection = (String) numOfDice.getSelectedItem();
            int numOfDiceToRoll = Integer.parseInt(selection);
            for (int i = 0; i < numOfDiceToRoll; i++) {
                int r = (int) ((Math.random() * 6) + 1);
                diceOutput += (" " + r);
            }
            label.setText(diceOutput);
            System.out.println("DiceService.RollEmListener.actionPerformed");
        }
    }
}
