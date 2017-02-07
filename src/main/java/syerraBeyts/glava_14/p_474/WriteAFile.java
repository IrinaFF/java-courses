package syerraBeyts.glava_14.p_474;

import java.io.*;
/**
 * Запись стоки в текстовый файл
 * @autor irinaff
 * @since 01.02.2017
 **/

public class WriteAFile {

    public static void main(String [] args) {
        try {
            FileWriter writer = new FileWriter("D:\\!Ирина\\889");
            writer.write("Привет, Фу!");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
