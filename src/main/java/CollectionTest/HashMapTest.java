package CollectionTest;

import java.util.*;


/**
 * HashMap обеспечивает максимальную скорость выборки, а порядок хранения его элементов не очевиден.
 * TreeMap хранит ключи отсортированными по возрастанию,
 * а LinkedHashMap хранит ключи в порядке вставки, но не обеспечивает скорость поиска HashMap.
 * @autor irinaff
 * @since 03.03.2017
 **/

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("0", "zero");
        hashmap.put("key", "one");
        hashmap.put("idx", "two");

        // 1.
        System.out.println("1.hashmap.entrySet()");
        for (Map.Entry<String, String> entry: hashmap.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
        System.out.println("-----------------");

        // 2.
        System.out.println("2.hashmap.keySet()");
        for (String key: hashmap.keySet())
            System.out.println(hashmap.get(key));
        System.out.println("-----------------");

        // 3.
        System.out.println("3.Iterator entrySet()");
        Iterator<Map.Entry<String, String>> itr = hashmap.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        System.out.println("-----------------");

        //Многомерные отображения
        Map<Person, List<? extends Pet>> personMap = new HashMap<>();

        personMap.put(new Person("Иван"), Arrays.asList(new Cat("Барсик"), new Cat("Мурзик")));
        personMap.put(new Person("Маша"), Arrays.asList(new Cat("Васька"), new Dog("Бобик")));
        personMap.put(new Person("Ирина"), Arrays.asList(new Cat("Рыжик"), new Dog("Шарик")));

        System.out.println("personMap: " + personMap);
        System.out.println("personMap.keySet(): " + personMap.keySet());

        //Метод keySet() возвращает контейнер Set, содержащий все ключи из personMap, который используется в цикле для перебора элементов Map.
        for(Person person : personMap.keySet()){
            System.out.println(person + " имеет");
            for (Pet pet : personMap.get(person)){
                System.out.println("  " + pet);
            }
        }
    }
}
