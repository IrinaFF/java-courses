package syerraBeyts.glava_10.ex_327;

import java.util.Date;

/**
 * Форматирование строки
 * @autor irinaff
 * @since 29.01.2017
 **/

public class StringFormat {
    public static void main (String [] args) {
        long i = 1000000000;
        int one = 20456654;
        double d = 475578.09876;
        float f1 = 25.6F;
        String s1 = String.format("%,d", i);
        String s2 = String.format("Мне нужно исправить %,.2f, ошибки", d);
        String s3 = String.format("%c", 444);
        String s4 = String.format("Уровень %,d из %,.2f", one, d);
        //полное представление даты и времени
        String s5 = String.format("%tc", new Date());
        //просто время
        String s6 = String.format("%tr", new Date());
        //день недели, месяц и число
        Date today = new Date();
        String s7 = String.format("%tA, %td %tB", today,today,today);
        String s = String.format("%tA, %<tB %<td", today);
        System.out.println(s5);
    }
}
