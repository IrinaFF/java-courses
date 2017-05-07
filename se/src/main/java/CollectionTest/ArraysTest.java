package CollectionTest;

import java.util.Arrays;

/**
 * http://developer.alexanderklimov.ru/android/java/array.php
 * @autor irinaff
 * @since 05.03.2017
 **/

public class ArraysTest {
    public static void main(String[] args) {
        int[] anyNumbers = {2, 8, 11};
        int[] luckyNumbers = anyNumbers; //массив остался прежним и вторая переменная обращается к нему же, а не создаёт вторую копию
        luckyNumbers[2] = 25;

        //System.out.println(anyNumbers.toString());
        System.out.println(Arrays.toString(anyNumbers));
        //System.out.println(Arrays.deepToString(anyNumbers));

        //Если же вам нужна копия массива, то используйте метод Arrays.copyOf()
        luckyNumbers = Arrays.copyOf(anyNumbers, anyNumbers.length);
        luckyNumbers[2] = 8;
        System.out.println(Arrays.toString(luckyNumbers));
        System.out.println(Arrays.toString(anyNumbers));

        //цикл
        for (int i = 0; i < anyNumbers.length; i++) {
                System.out.println(i + ": " + anyNumbers[i]);
        }
        //укороченный вариант записи
        for (int num : anyNumbers) {
            System.out.println(num);
        }
    }
}
