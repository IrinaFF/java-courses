package syerraBeyts.glava_5;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 24.01.2017
 **/

public class MixFor5 {
    public static void main (String[] args) {
        int x = 0;
        int y = 30;
        for (int outer = 0; outer < 3; outer++) {
            for (int inner = 4; inner > 1; inner--) {

                //x = x + 3;
                //x = x + 6;
                //x = x + 2;
                //x++;
                //x--;
                x = x + 0;

                y = y - 2;
                if (x == 6 ) {
                    break;
                }
                x = x + 3;
                System.out.println(inner + " inner: " + x + " " + y);
            }
            y = y - 2;
            System.out.println(outer + " outer: " + x + " " + y);
        }
        System.out.println(x + " " + y);
    }
}
