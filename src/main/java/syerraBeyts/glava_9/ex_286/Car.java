package syerraBeyts.glava_9.ex_286;

/**
 * @autor irinaff
 * @since 28.01.2017
 **/

public class Car {
    private String name;

    public Car(String n) {
        name = n;
        System.out.println("конструктор Car");
    }

    String getName() {
        return name;
    };
}
