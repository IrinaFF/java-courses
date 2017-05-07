package javarush;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 12.03.2017
 **/

public class Practice {
    public static void main(String ...args) {
        Boolean b = new Boolean("/true");
        System.out.println(b);
    }

    public static void main(String args) {
        Boolean b = new Boolean("/false");
        System.out.println(b == false);
    }
}
