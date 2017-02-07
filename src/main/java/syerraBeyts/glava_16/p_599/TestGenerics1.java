package syerraBeyts.glava_16.p_599;

/**
 * обобщения, обычный массив
 * Animal[] animals и takeAnimals (Animal[] animals)
 * @autor irinaff
 * @since 05.02.2017
 **/

public class TestGenerics1 {
    public static void main(String[] args) {
        new TestGenerics1().go();
    }

    public void go() {
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog [] dogs = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void takeAnimals (Animal[] animals) {
        for (Animal a: animals) {
            a.eat();
        }
    }
}
