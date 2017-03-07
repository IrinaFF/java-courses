package CollectionTest;

import java.util.Arrays;

/**
 * Многомерные массивы
 * @autor irinaff
 * @since 23.02.2017
 **/

public class ArrayMultiTest {
    public static void main(String[] args) {
        int[][] dd2 = new int[5][]; /* Матрица из 5 строк. Сколько элементов будет в каждой строке пока не известно. */
        for(int i=0; i<5; i++) {
            dd2[i] = new int[i+2];
        }
        System.out.println(Arrays.toString(dd2));
        System.out.println(Arrays.deepToString(dd2));

        for(int i=0; i<dd2.length; i++) {
            for(int j=0; j<dd2[i].length; j++) {
                System.out.print(dd2[i][j] + "\t");
            }
            System.out.println(); // Переходим на следующую строку
        }

        //Пример (заполняем двумерный массив случайными числами от 0 до 9 и выводим его на жкран в виде матрицы):

        int[][] da = new int[6][4];
        for(int i=0; i<da.length; i++) {
            for(int j=0; j<da[i].length; j++) {
                da[i][j] = (int)(Math.random()*10);
            }
        }
        for(int i=0; i<da.length; i++) {
            for(int j=0; j<da[i].length; j++) {
                System.out.print(da[i][j] + "\t");
            }
            System.out.println(); // Переходим на следующую строку
        }

        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        // трехмерный массив фиксированной длины
        int[][][] b = new int[2][4][4];

        //Двумерный массив - это массив одномерных массивов. Если вам нужен двумерный массив, то используйте пару квадратных скобок:
        //Представляйте двумерный массив как таблицу, где первые скобки отвечают за ряды, а вторые - за колонки таблицы

        String[][] arr = new String[4][3];

        arr[0][0] = "1";
        arr[0][1] = "Васька";
        arr[0][2] = "121987102";

        arr[1][0] = "2";
        arr[1][1] = "Рыжик";
        arr[1][2] = "2819876107";

        arr[2][0] = "3";
        arr[2][1] = "Барсик";
        arr[2][2] = "412345678";

        arr[3][0] = "4";
        arr[3][1] = "Мурзик";
        arr[3][2] = "587654321";

        //При резервировании памяти под многомерный массив необходимо указать память только для первого измерения
        int[][] twoD = new int[3][]; // память под первое измерение
        // далее резервируем память под второе измерение
        twoD[0] = new int[4];
        twoD[1] = new int[4];
        twoD[2] = new int[4];

        //Сначала мы поставили скобки у типа переменной, а потом у имени переменной. При этом мы использовали в качестве имени имя класса Integer.
        // Однако, Java догадывается, что на этот раз используется не класс, а имя и разрешает такой синтаксис. Но лучше так не выпендриваться.
        Integer[] Integer[] = {{1, 2, 3}, {4, 0, 0,},};
        System.out.println(Arrays.deepToString(Integer));

        //азмер двумерного массива измеряется интересным способом. Длина массива определяется по его первой размерности, то есть вычисляется количество рядов.
    }

}
