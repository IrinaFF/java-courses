package syerraBeyts.glava_12.ex_385;
import javax.swing.*;
import java.awt.event.*;
/**
 * @autor irinaff
 * @since 30.01.2017
 **/

//1. релизуем интерфейс ActionListener
public class SimpleGui1B implements ActionListener {
    JButton button;
    public static void main (String [] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        //2. регистрируем наше заинтересованность в кнопке
        //Добавь меня к своему списку слушателей
        //аргумент - объект класса реализующего ActionListener
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    //3. реазизуем метод actionPerformed интерфейса
    //это практический метод обработки событий
    //кнопка вызывает этот метод и отправляет объект ActionEvent
    public void actionPerformed(ActionEvent event) {
        button.setText("I'v been clicked!");
    }
}
