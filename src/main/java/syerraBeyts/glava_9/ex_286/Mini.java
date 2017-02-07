package syerraBeyts.glava_9.ex_286;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 28.01.2017
 **/

public class Mini extends Car {
    String color;

    public Mini() {
        this("Red");
        System.out.println("конструктор 1 Mini");
    }

    public Mini(String s) {
        super("Mini");
        color = s;
        System.out.println("конструктор 2 настоящий Mini");
    }

    public Mini( int i) {
        this("Red");
        color = "Blue";
        System.out.println("конструктор 3 Mini");
    }

    String getColor() {
        return color;
    };
}
