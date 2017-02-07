package syerraBeyts.glava_13.p_445;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

/**
 * пример List
 * @autor irinaff
 * @since 01.02.2017
 **/

public class List1 implements ListSelectionListener {

    JList list;

    public static void main(String [] args) {
        List1 gui = new List1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        //Конструктор
        String[] listEntries = {"alpha", "beta", "gamma", "delta",
                "epsilon", "zeta", "eta", "theta"};
        list = new JList(listEntries);

        //Создаем вертикальную полосу прокрутки для списка
        JScrollPane scroller = new JScrollPane(list);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        //frame.getContentPane().add(BorderLayout.SOUTH, list);

        //устанавливаем количесвтво строк, изображаемых до прокрутки
        list.setVisibleRowCount(4);

        //ограничиваем выбо до одной строки
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //регистрируем события в списке
        list.addListSelectionListener(this);

        frame.setSize(350,300);
        frame.setVisible(true);
    }

    //обрабатывавем события
    public void valueChanged(ListSelectionEvent lse) {
        //если не вставить такую проверку, получим событие дважды
        if (!lse.getValueIsAdjusting()) {//valueChanged
            //метод возвращает тип объект
            String selection = (String) list.getSelectedValue();
            System.out.println(selection);
        }
    }
}
