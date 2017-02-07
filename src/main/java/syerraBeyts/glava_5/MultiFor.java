package syerraBeyts.glava_5;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 24.01.2017
 **/

public class MultiFor {
    public static void main (String[] args) {

        for (int x = 0; x < 4; x++) {
            for(int y = 4; y > 2; y--) {
                System.out.println(x + " " + y);
            }
            if (x == 1) {
                x++;
            }
        }
    }
}
