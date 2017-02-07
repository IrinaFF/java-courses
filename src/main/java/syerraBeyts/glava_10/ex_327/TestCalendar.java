package syerraBeyts.glava_10.ex_327;

import java.util.Calendar;

/**
 * работа с календарем
 * @autor irinaff
 * @since 29.01.2017
 **/

public class TestCalendar {
    public static void main (String [] args) {
        Calendar c = Calendar.getInstance();
        //System.out.println(c.getClass());
        //устанавливаем время 200 год, январь, 7 число, 15 часов 40 минут
        c.set(2004,0,7,15,40);
        System.out.println(c.getTime());
        System.out.println("c.DATE= " + c.DATE);
        //превращаем в миллисекунды
        long day1 = c.getTimeInMillis();
        //добавляем час в миллисекундах
        day1 += 1000 * 60 * 60;
        //обновляем время
        c.setTimeInMillis(day1);
        System.out.println("Новый час " + c.get(c.HOUR_OF_DAY));
        //Добавляем к дате 35 дней
        c.add(c.DATE, 35);
        System.out.println("Добавить 35 дней " + c.getTime());
        //прокручиваем только дату на 35 дней (месяц не меняется)
        c.roll(c.DATE, 35);
        System.out.println("Прокрутить 35 дней " + c.getTime());
        //установить дату
        c.set(c.DATE, 1);
        System.out.println("Установить дату в 1 " + c.getTime());
    }

}
