package syerraBeyts.glava_14.p_482;

import java.io.*;

/**
 * чято можно сделать с объектом файл
 * @autor irinaff
 * @since 02.02.2017
 **/


public class File1 {
    public static void main(String [] args) {
        //1.Создать объект File, представляющий существующий файл:
        File f = new File("D:\\Test\\Новая папка");

        //2.Создать новый каталог:
        File dr = new File("D:\\Test\\Chapter7");
        dr.mkdir();
        //mkdirs(), вызывается в случае если путь к каталогу еще не создан,
        //в результате создается как сам каталог так и все его родители.
        File dr1 = new File("D:\\Test");

        //3.Вывести содержимое каталога:
        if (dr1.isDirectory()) {
            String [] dirContents = dr1.list();
            for (int i = 0; i <dirContents.length; i++) {
                System.out.println(dirContents[i]);
            }
        }
        //4.Получить абсолютный путь файла или каталога:
        System.out.println(dr.getAbsoluteFile());

        //5. Удалить срайл или каталог (при выполнении возвращает значение true):
        boolean isDeleted = f.delete();
        System.out.println(isDeleted);
        //isDeleted = dr.delete();
        //System.out.println(isDeleted);
    }
}
