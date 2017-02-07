package syerraBeyts.glava_16.p_599;

import java.util.ArrayList;

/**
 * обобщения
 * ArrayList<Dog> и takeAnimals1 (ArrayList<Animal> animals)
 * не работает
 * Dog[] dogs и takeAnimals(Animal[] animals)
 * работает но мб ошибка при выполнении
 * @autor irinaff
 * @since 05.02.2017
 **/

public class TestGenerics3 {
    public static void main(String[] args) {
        new TestGenerics3().go();
    }

    public void go() {
        ArrayList<Dog> dogs1 = new ArrayList<Dog>();
        dogs1.add(new Dog());
        dogs1.add(new Dog());

        //ошибка при компиляции, не проверяется при выполнении
        //takeAnimals1(dogs1);
        //нет ошибки при компиляции, ошибка при выполнении
        Dog[] dogs2 = {new Dog(), new Dog(), new Dog()};
        takeAnimals2(dogs2) ;
    }

    public void takeAnimals1 (ArrayList<Animal> animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }

    public void takeAnimals2(Animal[] animals) {
        animals[0] = new Cat();
    }
}
