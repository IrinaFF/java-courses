package CollectionTest;

import java.util.Arrays;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 05.03.2017
 **/

public class ArraysTest {
    public static void main(String[] args) {
        int[] anyNumbers = {2, 8, 11};
        int[] luckyNumbers = anyNumbers;
        luckyNumbers[2] = 25;

        System.out.println(anyNumbers.toString());
        System.out.println(Arrays.toString(anyNumbers));
        //System.out.println(Arrays.deepToString(anyNumbers));
        //for (int i = 0; i < anyNumbers.length; i++) {
            //System.out.println(mice);
        //}
    }
}
