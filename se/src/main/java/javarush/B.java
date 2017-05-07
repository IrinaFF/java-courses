package javarush;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 12.03.2017
 **/

public class B {
    public static void main(String[] args) {
        int x, y, z;
        x = 1;
        y = 2;
        z = 3;
        System.out.println(z >= y && y >= x);

        big_loop:
        for (int i = 0; i <3; i ++) {
            System.out.println("i=" + i);
            try {

                for (int j = 0; j < 3; j ++) {
                    System.out.println("j=" + j);

                    if (i==j) continue;
                    else if (i > j) continue big_loop;

                    System.out.println("A");
                }

            }
            finally {
                System.out.println("finally B");
            }
            System.out.println("C");
        }
    }
}
