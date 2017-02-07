package syerraBeyts.glava_7.ex_223;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 26.01.2017
 **/

public class MonsterTestDrive {
    public static void main (String [] args) {
        Monster [] ma = new Monster[3];
        ma[0] = new Vampire();
        ma[1] = new Dragon();
        ma[2] = new Monster();
        for (int x = 0; x < 3; x++) {
            ma[x].frighten(x);
            //System.out.println(ma[x].frighten(x));
        }

    }
}
