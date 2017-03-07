package CollectionTest;

import java.util.Arrays;

/**
 * Сортировка методом пузырька
 * Суть алгоритма такова. Если пройдёмся по любому массиву установив правильный порядок
 * в каждой паре соседних элементов, то после того прохода на последнем месте массива
 * гарантированно будет стоять нужный элемент (самый большой для сортировки по возрастанию
 * или самый маленький для сортировки по убыванию).
 * Если ещё раз пройтись по массиву с такими же преобразованиями, то и на предпоследнем месте
 * гарантированно окажется нужный элемент. И так далее.
 * @autor irinaff
 * @since 23.02.2017
 **/

public class ArraysSort1 {
    public static void main(String[] args) {
        int[] a = {2, 9, 1, 4, 3, 5, 2};
        System.out.println(Arrays.toString(a));
        int count = 0;
        /* Внешний цикл постоянно сужает фрагмент массива,
         * который будет рассматриваться, ведь после каждого прохода
         * внутреннего цикла на последнем месте фрагмента будет
         * оказываться нужный элемент (его не надо рассматривать снова).
         */
        for (int i = a.length - 1; i >= 2; i--) {

            System.out.println("i=" + i);
            /* В переменной sorted мы будем хранить признак того,
             * отсортирован ли массив. Перед каждым проходом внутреннего
             * цикла будем предполагать, что отсортирован, но если совершим
             * хоть одну перестановку, то значит ещё не конца отсортирован.
             * Этот приём, упрощающий сортировку, называется критерием Айверсона.
             */
            boolean sorted = true;
            /* Во внутреннем цикле мы проходимся по фрагменту массива, который
             * определяется внешним циклом. В этом фрагменте мы устанавливаем
             * правильный порядок между соседними элементами, так попарно
             * обрабатывая весь фрагмент.
             */
            for (int j = 0; j < i; j++) {
                System.out.print (j + " ");
                /* Если порядок соседних элементов не правильный, то их
                 * надо обменять местами. И запомнить, что была перестановка.
                 */
                if (a[j] > a[j+1]) {
                    count++;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    sorted = false;
                }
            }
            System.out.println("-----");
            /* Если массив отсортирован (т.е. не было ни одной перестановки
             * во внутреннем цикле, значит можно прекращать работу внешнего
             * цикла.
             */
            if(sorted) {
                System.out.println("sorted");
                System.out.println(Arrays.toString(a));
                System.out.println("count=" + count);
                break;
            }

        }
    }
}