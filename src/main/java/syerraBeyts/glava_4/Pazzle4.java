package syerraBeyts.glava_4;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 15.01.2017
 **/

public class Pazzle4 {
    public static void main(String[] args){
        Pazzle4b[] obs = new Pazzle4b[6];
        int y = 1;
        int x = 0;
        int result = 0;
        while (x < 6) {
            obs[x] = new Pazzle4b();
            obs[x].ivar = y;
            y = y * 10;
            x = x + 1;
        }
        x = 6;
        while (x > 0) {
            x = x - 1;
            result = result + obs[x].doStaff(x);
            System.out.println("промужуточный результат " + result);
        }
        System.out.println("Результат " + result);
    }
}

class Pazzle4b {
    int ivar;
    public int doStaff(int factor) {
        System.out.println("ivar " + ivar);
        System.out.println("factor " + factor);
        if (ivar > 100) {
            return ivar*factor;//ivar + factor;
        } else {
            return ivar*(5-factor);//ivar + factor;//
        }
    }
}
