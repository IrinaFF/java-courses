package syerraBeyts.glava_9.ex_282;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 26.01.2017
 **/

abstract class Animal {
    String picture;
    String food;
    int hunger;
    int boundaries;
    int location;

    public Animal() {
        System.out.println("создание Animal");
    }

    public void makeNoise() {};
    public void eat() {};
    public void sleep() {};
    public void roam() {};
}
