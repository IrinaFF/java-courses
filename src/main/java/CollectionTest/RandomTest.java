package CollectionTest;

import java.util.Random;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 08.03.2017
 **/

public class RandomTest {
    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 1; i <100; i++) {
            int index = rnd.nextInt(i+1);
            System.out.println(i + ": " + index);
        }
    }
}
