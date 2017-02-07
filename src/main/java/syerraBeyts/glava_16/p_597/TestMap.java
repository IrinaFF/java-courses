package syerraBeyts.glava_16.p_597;

import java.util.*;
/**
 * пример отображения
 * @autor irinaff
 * @since 04.02.2017
 **/

public class TestMap {
    public static void main(String[] args) {
        //HashMap нуэжается в двух типовых параметрах
        //ключ, значение
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        scores.put("Кэти", 42);
        scores.put("Берт", 343);
        scores.put("Скайлер", 420);

        System.out.println(scores);
        System.out.println(scores.get("Берт"));
    }
}
