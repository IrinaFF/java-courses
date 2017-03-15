package ru.lesson.lessons.lesson_10v1;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 12.03.2017
 **/

public class myArrayList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    /*
    Добавляет новый элемент в список. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    */
    public void add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    /*
    Добавляет новый элемент в список в указанную позицию. При достижении размера внутреннего
    массива происходит его увеличение в два раза.
    */
    public void add(T item, int pos) {
        if(pointer == array.length-1)
            resize(array.length*2); // увеличу в 2 раза, если достигли границ
        if (pos >= 0)

        array[pointer++] = item;
    }

    /*
    Возвращает элемент списка по индексу.
    */
    public T get(int index) {
        return (T) array[index];
    }

    /*
    Удаляет элемент списка по индексу. Все элементы справа от удаляемого
    перемещаются на шаг налево. Если после удаления элемента количество
    элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
    то внутренний массив уменьшается в два раза, для экономии занимаемого
    места.
    */
    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < pointer; i++)
                if (array[i] == null) {
                    remove(i);
                    return true;
                }
        } else {
            for (int i = 0; i < pointer; i++)
                if (o.equals(array[i])) {
                    remove(i);
                    return true;
                }
        }
        return false;
    }

    /*Возвращает количество элементов в списке*/
    public int size() {
        return pointer;
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
