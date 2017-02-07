package syerraBeyts.glava_14.p_482;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
/**
 * чтение изх текстового файла
 * @autor irinaff
 * @since 02.02.2017
 **/

public class ReadAFile {
    public static void main(String [] args) {
        /*
        //сначала создадим файл и запишем в него текст
        try {
        File myFile = new File("D:\\Test\\MyText.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write("Сколько будет 2 + 2?/4\n");
            writer.write("Сколько будет 20 +\n");
            writer.write("22/42\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        */
        try {
            File myFile = new File("D:\\Test\\MyText.txt");
            //поток соединения для символов, который подключается к текстовому файлу
            FileReader fileReader = new FileReader(myFile);
            //цепной поток работающий с символами
            BufferedReader reader = new BufferedReader(fileReader);
            //создаем строковую переменную для временного хранения каждой строки в процессе чтения
            String line = null;

            //прочитай строку текста и присвой ее переменной line
            //пока перемнная не пуста выводи на экран прочтенную строку
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
