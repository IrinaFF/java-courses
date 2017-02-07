package syerraBeyts.glava_15.p_554;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 03.02.2017
 **/

public class Accum {
    private static Accum a = new Accum();

    private int counter = 0;

    private Accum() {
        System.out.println("конструктор Accum()");
    }
    public static Accum getAccum() {
        return a;
    }

    public int getCount() {
        return counter;
    }

    public synchronized void updateCounter (int add) {
        counter += add;
    }



}
