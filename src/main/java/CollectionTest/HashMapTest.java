package CollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TODO: comment
 *
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
    }
}
