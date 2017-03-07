package CollectionTest;

import java.util.Arrays;

/**
 * Сортировка выбором
 * Рассмотрим пример сортировки по возрастанию. То есть на начальной позиции в массиве
 * должен стоять минимальный элемент, на следующей — больший или равный и т. д.,
 * на последнем месте должен стоять наибольший элемент.
 * Суть алгоритма такова. Во всём отыскиваем минимальный элемент,
 * меняем его местами с начальным. Затем в оставшейся части массива
 * (т. е. среди всех элементов кроме начального) снова отыскиваем
 * минимальный элемент, меняем его местами уже со вторым элементом в массиве. И так далее.
 **/

public class ArraysSort2 {
    public static void main(String[] args) {
        int[] a = {2, 9, 1, 4, 3, 5, 2};
        System.out.println(Arrays.toString(a));
        int count = 0;
        for (int i = 0; i < a.length; i++) {
        /* Предполагаем, что начальный элемент рассматриваемого
         * фрагмента и будет минимальным.
         */
            int min = a[i]; // Предполагаемый минимальный элемент
            int imin = i; // Индекс минимального элемента
            /* Просматриваем оставшийся фрагмент массива и ищем там
             * элемент, меньший предположенного минимума.
             */
            for (int j = i+1; j < a.length; j++) {
                count++;
                /* Если находим новый минимум, то запоминаем его индекс.
                 * И обновляем значение минимума.
                 */
                if (a[j] < min) {
                    min = a[j];
                    imin = j;
                }
            }
            /* Проверяем, нашёлся ли элемент меньше, чем стоит на
             * текущей позиции. Если нашёлся, то меняем элементы местами.
             */
            if (i != imin) {
                int temp = a[i];
                a[i] = a[imin];
                a[imin] = temp;
            }
            System.out.println("[" + i + "]" + Arrays.toString(a));
        }
        System.out.println("count=" + count);
    }
}