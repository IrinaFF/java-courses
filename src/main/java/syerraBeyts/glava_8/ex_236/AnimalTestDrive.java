package syerraBeyts.glava_8.ex_236;

/**
 * @autor irinaff
 * @since 26.01.2017
 **/

public class AnimalTestDrive {
    public static void main (String [] args) {
        MyAnimalList list = new MyAnimalList();
        Dog a = new Dog();
        Cat c = new Cat();
        list.add(a);
        list.add(c);

        if (a.equals(c)) {
            System.out.println("a.equals(c) - true");
        } else {
            System.out.println("a.equals(c) - false");
        }
        System.out.println(c.getClass());
        System.out.println(c.hashCode());
        System.out.println(c.toString());
    }
}
