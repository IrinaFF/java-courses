package syerraBeyts.glava_12.ex_385;
import javax.swing.*;
/**
 * мой первый графический интерфейс
 * @autor irinaff
 * @since 30.01.2017
 **/

public class SimpleGui1 {
    public static void main (String [] args) {
        //создаем фрейм
        JFrame frame = new JFrame();
        //создаем виджет - кнопку и даем текст который будет на ней отображаться
        JButton button = new JButton("click me");
        //эта строка завершает работу программы при закрытии окна
        //если вы не добавите ее, то приложение будет висеть на экране вечно
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //добавляем кнопку на панель фрейма
        frame.getContentPane().add(button);
        //присваиваем фрейму размер  в пикселях
        frame.setSize(300,300);
        //выводим фрейм на экран, делаем видимым
        frame.setVisible(true);
    }
}
