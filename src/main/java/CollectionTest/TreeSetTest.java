package CollectionTest;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by IFatkullina on 06.03.2017.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //HashSet не может гарантировать, что данные будут отсортированы, так как работает по другому алгоритму.
        // Если сортировка для вас важна, то используйте TreeSet.
        Random random = new Random(30);
        SortedSet<Integer> numberSet = new TreeSet<>();

        for(int i = 0; i < 1000; i++) {
            numberSet.add(random.nextInt(10));
        }
        System.out.println(numberSet.toString());
        System.out.println(numberSet.size());

        SortedSet<String> countrySet = new TreeSet<>();
        countrySet.add("Россия");
        countrySet.add("Франция");
        countrySet.add("Гондурас");
        countrySet.add("Кот-Д'Ивуар"); // любимая страна всех котов

        System.out.println(countrySet.toString());
    }
}
