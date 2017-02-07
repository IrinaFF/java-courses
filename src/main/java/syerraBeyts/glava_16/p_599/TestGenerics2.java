package syerraBeyts.glava_16.p_599;

import java.util.ArrayList;

/**
 * обобщения
 * ArrayList<Animal> и takeAnimals1 (ArrayList<Animal> animals)
 * работает
 * @autor irinaff
 * @since 05.02.2017
 **/

public class TestGenerics2 {
    public static void main(String[] args) {
        new TestGenerics2().go();
    }

    public void go() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());

        takeAnimals (animals) ;
    }

    public void takeAnimals (ArrayList<Animal> animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }
}
