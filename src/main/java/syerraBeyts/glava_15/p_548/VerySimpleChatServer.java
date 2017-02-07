package syerraBeyts.glava_15.p_548;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * очень простой чат-сервер для обеих версий чат-клиентов
 * @autor irinaff
 * @since 03.02.2017
 **/

public class VerySimpleChatServer {
    //массив с потоками отправки сообщений клиентов чата
    ArrayList clientOutputStreams;

    public static void main (String[] args) {
        new VerySimpleChatServer().go();
    }

    public void go() {
        clientOutputStreams = new ArrayList();
        try {
            //создание порта для подключения клиентов
            ServerSocket serverSock = new ServerSocket(5000);
            while (true) {
                //ожидание нового подключения клиента
                Socket clientSocket = serverSock.accept();
                //создание для нового клиента потока отправки сообщений
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                //и запись ссылки на него в массив
                clientOutputStreams.add(writer);
                //создание потока с заданием run в классе ClientHandler (чтение сообщений)
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start() ;
                System.out.println("got a connection");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // Закрываем go

    //метод для трансляции соббщений всем клиентам
    public void tellEveryone(String message) {
        System.out.println("tellEveryone: " + message);
        System.out.println("clientOutputStreams.size: " + clientOutputStreams.size());
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            System.out.println("while");
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                System.out.println("writer.println " + message);
                writer.flush();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        } // Конец цикла while
    } // Закрываем tellEveryone

    //вложенный класс для клиента чата
    public class ClientHandler implements Runnable {
        BufferedReader reader;//буфер чтения
        Socket sock;//сокет

        //конструктор
        //подключение к сокету потока чтения сообщений клиентов
        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch(Exception ex) {ex.printStackTrace();}
        } // Закрываем конструктор

        public void run() {
            System.out.println("run");
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    //трансляция сообщения всем клиентам
                    tellEveryone(message);
                } // Закрываем while
            } catch(Exception ex) {ex.printStackTrace();}
        } // Закрываем run
    } // Закрываем вложенный класс




} // Закрываем класс
