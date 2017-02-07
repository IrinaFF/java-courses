package syerraBeyts.glava_15.p_511;

import java.io.*;
import java.net.*;
/**
 * Программа создает сокет и объект BufferedReader с помощью других
 * потоков, а затем считывает одну строку, которую ей передает
 * серверное приложение, работающее на порту 4242.
 * @autor irinaff
 * @since 02.02.2017
 **/

public class DailyAdviceClient {
    public void go() {
        try {
            //создаем соединение через сокет к приложеничЮ работающему на порту 4242
            //на том же компьютере, где выполняется данный код localhost
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            //подключаем BufferedReader к InputStreamReader, который уже соединен с исходящим потоком сокета
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Сегодня ты должен: " + advice);

            reader.close();

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String [] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}
