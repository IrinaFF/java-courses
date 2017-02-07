package syerraBeyts.glava_15.p_511;

import java.io.*;
import java.net.*;

/**
 * программа создает ServerSocket и ожидает клиентские запросы. При  получении такого запроса (когда клиент выполнил для этого приложения
 * new Socket()) сервер создает объект Socket и устанавливает соединение
 * с этим клиентом. Сервер создает экземпляр PrintWriter
 * (с помощью исходящего потока из сокета) и отправляет клиенту сообщение.
 * @autor irinaff
 * @since 02.02.2017
 **/

public class DailyAdviceServer {
    //Массив с ежедневными советами
    String[] adviceList =
            {"Ешьте меньшими порциями", "Купите облегающие джинсы. Нет, они не делают вас полнее.",
                    "Два слова: не годится", "Будьте честны хотя бы сегодня. Скажите своему начальнику все, что вы *на самом деле* о нем думаете.",
                    "Возможно, вам стоит подобрать другую прическу."};
    public void go() {
        //благодаря ServerSocket приложение отслеживает клиентские запросы на порту 4242
        //на том же компьютере где выполняется данный код
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            //сервер входит в постоянный цикл ожидая клиенских подключений
            //и обслуживая их
            while (true) {
                System.out.println("до accept");
                //метод accept блокирует приложение до тех пор пока не поступит запрос
                //после чего возвращает сокет на анонимном порту для взаимодействия с клиентом
                //заставляем сервер ждать подключений
                Socket sock = serverSocket.accept();
                System.out.println("после accept");
                //теперь мы используем соединение объекта Socket с клиентом
                //для создания экземпляра PrintWriter
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                //после чего отправляем с его помощью строку с советом
                writer.println(advice);
                //затем мы закрываем сокет, т.к. работа с клиентом закончена
                writer.close();
                System.out.println(advice);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvice() {
       int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String [] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
