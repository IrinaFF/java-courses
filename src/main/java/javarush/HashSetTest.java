package javarush;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by IFatkullina on 06.03.2017.
 */
public class HashSetTest {
    public static void main(String[] args) {
        //порядок добавления стран во множество будет непредсказуемым.
        // HashSet использует хэширование для ускорения выборки
            HashSet<String> countryHashSet = new HashSet<>();
            //метод add(Object o) добавляет объект в множество только в том случае, если его там нет.
            countryHashSet.add("Россия");
            countryHashSet.add("Франция");
            countryHashSet.add("Гондурас");
            countryHashSet.add("Кот-Д'Ивуар"); // любимая страна всех котов

        Iterator<String> iterator = countryHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Конвертируем HashSet в массив
        String[] myArray = {};
        myArray = countryHashSet.toArray(new String[countryHashSet.size()]);

        Random random = new Random(30);
        Set<Integer> numberSet = new HashSet<>();

        for(int i = 0; i < 1000; i++) {
            numberSet.add(random.nextInt(10));
        }
        System.out.println(numberSet.toString());
        System.out.println(numberSet.size());

    }
//Класс LinkedHashSet расширяет класс HashSet, не добавляя никаких новых методов.
// Класс поддерживает связный список элементов набора в том порядке,
// в котором они вставлялись. Это позволяет организовать упорядоченную итерацию вставки в набор.
}
