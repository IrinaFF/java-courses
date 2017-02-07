package syerraBeyts.glava_15.p_516;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 * клиентское приложение для чата в два этапа
 * верси чата, которая умеет отправлять сообщения на сервер,
 * но не способна принимать их от других участников
 * @autor irinaff
 * @since 03.02.2017
 **/

public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public void go() {
        // Создаем GUI и подключаем слушатель для событий к кнопке Send
        // Вызываем метод setUpNetworking()
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing) ;
        mainPanel.add(sendButton) ;
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        setUpNetworking();
        frame.setSize(400,500);
        frame.setVisible(true);

}
    private void setUpNetworking() {
        // Создаем сокет и PrintWriter
        // Присваиваем PrintWriter переменной writer
        try {
            //мы используем локалхост, поэтому можно тестировать
            //клиет и сервер на одном компьютере
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
        // Получаем текст из текстового поля и отправляем
        // его на сервер с помощью переменной writer (PrintWriter)
            try {
                writer.print(outgoing.getText());
                writer.flush();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    } // Закрываем вложенный класс SendButtonListener
}// Закрываем внешний класс
