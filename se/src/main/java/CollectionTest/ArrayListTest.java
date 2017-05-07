package CollectionTest;

import java.util.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 05.03.2017
 **/

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        //Если заранее известно, сколько элементов следует хранить,
        // то перед заполнением массива вызовите метод ensureCapacity():
        list.ensureCapacity(10);
        list.add("0");
        list.add("1");
        list.add("9");
        list.add("10");
        list.add("15");
        list.add(5,"100");
        list.set(3, "3");
        //list.remove(5);
        //list.remove("15");
        list.trimToSize();
        System.out.println(list.get(1));
        System.out.println(list.indexOf("15"));
        //Если вы уверены, что списочный массив будет иметь постоянный размер,
        // то можете использовать метод trimToSize().
        // Это может способствовать рациональному использованию памяти.
        list.trimToSize();

        for (int i=0; i < list.size(); i++ ) {
            System.out.println(i + " " + list.get(i));
        }
        //Метод contains() проверяет, присутствует ли объект в списке
        System.out.println(list.contains("200"));

        //Сколько раз совпадают элементы
        list.add("15");
        System.out.println("frequency:" + Collections.frequency(list,"15"));

        String[] myArray = {}; // конвертируем ArrayList в массив
        myArray = list.toArray(new String[list.size()]);



        //очистка массива
        list.clear();
    }
}
