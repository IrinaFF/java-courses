package syerraBeyts.glava_9.ex_282;

/**
 * @autor irinaff
 * @since 27.01.2017
 **/

public class Duck extends Animal {
    int size;

    public Duck(int newSize) {
        super();
        System.out.println("создание Duck");
        //так делать нельзя
        //Animal();
        size = newSize;
    }

}
