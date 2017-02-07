package syerraBeyts.glava_15.p_548;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * клиентское приложение для чата в два этапа
 * версия чата, которая способна как отправлять сообщение на сервер (взаимодействуя с GUI)
 * так и считывать входящие сообщения, полученные от сервера,
 * отображая их в прокручиваемой текстовой области.
 * @autor irinaff
 * @since 03.02.2017
 **/

public class SimpleChatClient {
    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static void main (String [] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }

    public void go() {
        // Создаем GUI и подключаем слушатель для событий к кнопке Send
        // Вызываем метод setUpNetworking()
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();

        incoming = new JTextArea(15,20);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true) ;
        incoming.setEditable(false);

        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS) ;
        qScroller.setHorizontalScrollBarPolicy (ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER) ;

        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(qScroller);
        mainPanel.add(outgoing) ;
        mainPanel.add(sendButton) ;

        setUpNetworking();

        //мы запускаем новый поток, используя вложенный класс в качестве Runnable (задачи)
        //работа потока заключаетс в чтении данных с сервера через сокет
        //и выводе любых входящихх сообщений в прокручиваемую текстовую область
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
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

            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);

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
                writer.println(outgoing.getText());
                System.out.println("writer.println " + outgoing.getText());
                writer.flush();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    } // Закрываем вложенный класс SendButtonListener

    //это работа которую выполняет поток
    public class IncomingReader implements Runnable {
        //в методе поток входит в цикл пока ответ сервер будет null
        //считыввает за раз одну тсроку и добавляет ее в прокручиваемую тектовую область
        public void run() {
            System.out.println("run");
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    incoming.append(message + "\n");
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}// Закрываем внешний класс
