package syerraBeyts.glava_16.p_599;

import java.util.ArrayList;

/**
 * обобщения
 * аргумент для метода, способный принимать
 * ArrayList любого дочернего от Animal типа.
 * @autor irinaff
 * @since 05.02.2017
 **/

public class TestGenerics4 {
    public static void main(String[] args) {
        new TestGenerics4().go();
    }

    public void go() {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        takeAnimals(dogs);
    }

    //то же самое
    public <T extends Animal> void takeAnimals1 (ArrayList<T> animals) {}

    public void takeAnimals (ArrayList<? extends Animal> animals) {
        for (Animal a: animals) {
            a.eat();
            //не скомпилируется
            //animals.add(new Cat()) ;
        }
    }

    //public <T extends Animal> void takeThing(ArrayList<T> one, ArrayList<T> two)
    //public void takeThing (ArrayList<? extends Animal> one, ArrayList<? extends Animal> two)
}
