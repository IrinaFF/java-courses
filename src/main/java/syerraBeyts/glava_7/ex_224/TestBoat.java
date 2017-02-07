package syerraBeyts.glava_7.ex_224;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 26.01.2017
 **/

public class TestBoat {
    public static void main (String [] args) {
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();

        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}
