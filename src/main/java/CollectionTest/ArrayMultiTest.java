package CollectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Многомерные массивы
 * @autor irinaff
 * @since 23.02.2017
 **/

public class ArrayMultiTest {
    private static Logger log = Logger.getLogger(ArrayMultiTest.class.getName());

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
        //Однако, Java догадывается, что на этот раз используется не класс, а имя и разрешает такой синтаксис. Но лучше так не выпендриваться.
        Integer[] Integer[] = {{1, 2, 3}, {4, 0, 0,},};
        System.out.println(Arrays.deepToString(Integer));

        //размер двумерного массива измеряется интересным способом.
        // Длина массива определяется по его первой размерности, то есть вычисляется количество рядов.
        int[][] matrix = new int[4][5];
        System.out.println("matrix: " + matrix.length);
        //А если мы хотим узнать количество столбцов в ряду? Тогда указываете ряд, а затем вычисляете у него количество столбцов.
        //число колонок у третьего ряда
        //в массивах ряды могут содержать разное количество столбцов
        System.out.println("matrix[2]: " + matrix[2].length);

        //Сложить два массива
        //Предположим, у вас есть два массива, и вам нужно их соединить и получить общий массив.
        String[] week1 = new String[] { "Понедельник", "Вторник", "Среда" };
        String[] week2 = new String[] { "Четверг", "Котопятница", "Субкота",
                "Воскресенье" };
        String[] week = concatArray(week1, week2); // будет возвращён массив всех семи дней недели
        System.out.println(Arrays.toString(week));

        //Взять часть массива
        double[] digits = new double[] {6.5, 3.1, 5.72};
        double[] part = copyPartArray(digits, 1);
        System.out.println(Arrays.toString(part));

        String[] weekday = new String[] { "Понедельник", "Вторник", "Среда" };

        // нам нужен массив со второго элемента
        String[] weeks = copyPartArray(weekday, 1); // вернёт Вторник и Среда
        // выводим второй элемент из полученного массива, т.е. Среда
        System.out.println(Arrays.toString(weeks));

        // создадим массив и перемешаем его
        int[] mSolutionArray = { 0};//, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        shuffleArray(mSolutionArray);
        System.out.println(Arrays.toString(mSolutionArray));

        log.info(Arrays.toString(mSolutionArray));

        //Поиск элементов строкового массива по начальным символам
        //Допустим, у нас есть строковый массив и нам нужно по первым символам найти все слова, которые входят в данный массив
        final String[] catNamesArray = new String[] { "Рыжик", "Барсик", "Мурзик",
                "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
                "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба" };

        // Применим метод. Ищем по буквам "мур":

        List<String> words = searchFromStart(catNamesArray, "мур");
        log.info("Поиск элементов: "+Arrays.toString(words.toArray()));

    }
    //метод для склеивания двух double массивов
    static private double[] concatArray(double[] a, double[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        double[] r = new double[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }
    // метод для склеивания двух строковых массивов
    static private String[] concatArray(String[] a, String[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        String[] r = new String[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    // Взять часть массива, start - с какой позиции нужно получить новый массив, отсчёт с 0
    static private double[] copyPartArray(double[] a, int start) {
        if (a == null)
            return null;
        if (start > a.length)
            return null;
        double[] r = new double[a.length - start];
        System.arraycopy(a, start, r, 0, a.length - start);
        return r;
    }

    static private String[] copyPartArray(String[] a, int start) {
        if (a == null)
            return null;
        if (start > a.length)
            return null;
        String[] r = new String[a.length - start];
        System.arraycopy(a, start, r, 0, a.length - start);
        return r;
    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    //Поиск элементов строкового массива по начальным символам
    public static ArrayList<String> searchFromStart(String[] inputArray, String searchText) {
        ArrayList<String> outputArray = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            if (searchText.compareToIgnoreCase(inputArray[i].substring(0,
                    searchText.length())) == 0) {
                outputArray.add(inputArray[i]);
            }
        }
        return outputArray;
    }
}
