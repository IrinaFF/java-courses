package syerraBeyts.glava_8.ex_236;

/**
 * возможно это худший способ создания с нуля
 * собственного класса вроде ArrayList
 * @autor irinaff
 * @since 26.01.2017
 **/

public class MyAnimalList {
    private Animal [] animals = new Animal[5];
    //будем увеличиваеть его при каждом добавлении объекта Dog
    private int nextIndex = 0;

    public void add(Animal a) {
        //если мы еще не дошли до предела массива
        if (nextIndex < animals.length) {
            animals[nextIndex] = a;
            System.out.println("Animal добавлен я вчейку " + nextIndex);
            nextIndex++;
        }
    }
}
