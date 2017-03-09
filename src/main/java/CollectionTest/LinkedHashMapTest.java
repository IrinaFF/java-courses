package CollectionTest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * HashMap обеспечивает максимальную скорость выборки, а порядок хранения его элементов не очевиден.
 * TreeMap хранит ключи отсортированными по возрастанию,
 * а LinkedHashMap хранит ключи в порядке вставки, но не обеспечивает скорость поиска HashMap.
 * @autor irinaff
 * @since 03.03.2017
 **/

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> linkedHashMap1 = new LinkedHashMap<Integer, String>();
        linkedHashMap1.put(1, "obj1");
        linkedHashMap1.put(15, "obj15");
        linkedHashMap1.put(4, "obj4");
        linkedHashMap1.put(38, "obj38");

        Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(15, 0.75f, false) {{
            put(1, "obj1");
            put(15, "obj15");
            put(4, "obj4");
            put(38, "obj38");
        }};
        // {1=obj1, 15=obj15, 4=obj4, 38=obj38}
        linkedHashMap.get(1); // or linkedHashMap.put(1, "Object1");
        // {15=obj15, 4=obj4, 38=obj38, 1=obj1}

        // 1.
        System.out.println("1.Iterator entrySet()");
        Iterator<Map.Entry<Integer, String>> itr1 = linkedHashMap.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry<Integer, String> entry = itr1.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("-----------------");

        // 2.
        System.out.println("2.Iterator keySet()");
        Iterator<Integer> itr2 = linkedHashMap.keySet().iterator();
        while(itr2.hasNext())
            System.out.println(itr2.next());
        System.out.println("-----------------");

        // 3.
        System.out.println("3. Iterator values()");
        Iterator<String> itr3 = linkedHashMap.values().iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());
        System.out.println("-----------------");
    }
}
