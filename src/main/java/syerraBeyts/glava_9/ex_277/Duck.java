package syerraBeyts.glava_9.ex_277;

/**
 * @autor irinaff
 * @since 27.01.2017
 **/

public class Duck {
    int pounds = 6;
    float flotability = 2.1F;
    String name = "Универсальная";
    long[] features = {1,2,3,4,5,6,7};
    boolean canFly = true;
    int maxSpeed = 25;

    public Duck() {
        System.out.println("Утка типа 1");
    }

    public Duck(boolean fly) {
        canFly = fly;
        System.out.println("Утка типа 2");
    }

    public Duck(String n, long[] f) {
        name = n;
        features = f;
        System.out.println("Утка типа 3");
    }

    public Duck(int w, float f) {
        pounds = w;
        flotability = f;
        System.out.println("Утка типа 4");
    }

    public Duck(float density, int max) {
        flotability = density;
        maxSpeed = max;
        System.out.println("Утка типа 5");
    }
}
