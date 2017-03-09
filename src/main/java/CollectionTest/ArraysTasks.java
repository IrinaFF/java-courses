package CollectionTest;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 07.03.2017
 **/

public class ArraysTasks {
    private static Logger log = Logger.getLogger(ArraysTasks.class.getName());
    public static void main(String[] args) {

        //Имеется массив из четырех чисел int[] numbers = {3, 9, 11, 15};. Поменяйте местами первый и второй элемент массива
        int[] numbers = {3, 9, 11, 15};
        int a = numbers[0];
        numbers[0] = numbers[1];
        numbers[1] = a;
        log.info(Arrays.toString(numbers));

        //Создайте массив из всех чётных чисел от 2 до 30 и выведите элементы массива на экран.
        int b = 2;
        int c = 30;
        int[] m = new int[c/b];
        int k = 0;
        for (int i = 0; i < c/b ; i++) {
            k = k+ b;
            m[i] = k;
        }
        log.info(m.length + ", " + Arrays.toString(m));

        //Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
        //а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1)
        int b1 = 2;
        int c1 = 99;
        int[] m1 = new int[c1/b1 + 1];
        int k1 = 1;
        for (int i = 0; i < c1/b1 + 1 ; i++) {
            m1[i] = k1;
            k1 = k1 + 2;
        }
        log.info(m1.length + ", " + Arrays.toString(m1));
        for (int i = m1.length-1; i >0 ; i--) {
            System.out.print(m1[i] + ", ");
        }
        System.out.println("");

        //Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран.
        // Напоминаем, что первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
        int[] m2 = new int[20];
        for (int i = 0; i < m2.length ; i++) {
            if ((i != 0)&&(i != 1)) {
                m2[i] = m2[i-2] + m2[i-1];
            } else {
                m2[i] = 1;
            }
        }
        log.info(Arrays.toString(m2));

        //Задача: Имеется статистика, сколько мышей поймал кот Барсик за год по месяцам в виде массива:
        int[] mice = new int[] { 4, 9, 3, 22, 5, 18, 25, 7, 11, 15, 5, 19 };
        System.out.println(getMax(mice));
        System.out.println(getMin(mice));
        //Написать метод getMax(), который вычисляет максимальное значение из массива.
        // Ну и метод getMin() для нахождения минимального значения.

        //Имеется массив, нужно переставить элементы массива в обратном порядке.
        mice = new int[] { 4, 9, 3, 22, 5, 18, 25, 7, 11, 15, 5, 19 };
        int[] miceR = new int[mice.length];
        for (int i = mice.length-1, j =0; i >=0; i--, j++) {
            miceR[j] = mice[i];
        }
        System.out.println(Arrays.toString(miceR));
    }

    public static int getMax(int[] b) {
        int rez = b[0];
        for (int i = 1; i < b.length; i++) {
            if (rez < b[i]) rez = b[i];
        }
        return rez;
    }
    public static int getMin(int[] b) {
        int rez = b[0];
        for (int i = 1; i < b.length; i++) {
            if (rez > b[i]) rez = b[i];
        }
        return rez;
    }
}
