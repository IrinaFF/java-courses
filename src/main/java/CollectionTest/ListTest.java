package CollectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 05.03.2017
 **/

public class ListTest {
    public static void main(String[] args) {
        //List реализует более общий интерфейс коллекции Collection
        Collection<String> mCatNames = new ArrayList<String>();

        //Но у Collection нет методов set() и get(), поэтому
        // работать с таким интерфейсом не очень удобно.
        //Для создания массива можно не только добавлять по одному объекту
        // через метод add(), но и сразу массив через метод Arrays.asList().
        List<Integer> numbers = Arrays.asList(1, 2, 5, 9, 11);
        //Если вы определили массив таким образом, то уже не можете вставлять
        //или удалять другой элемент (методы add() и delete())
        numbers.set(2, 33); // так можно
        numbers.add(34); // нельзя, ошибка во время исполнения
    }
}
