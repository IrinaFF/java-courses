package others.Array;

import java.util.Arrays;

/**
 * @autor irinaff
 * @since 23.02.2017
 **/

public class ArrayEx {
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
    }
}
