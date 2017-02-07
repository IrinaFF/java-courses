package syerraBeyts.glava_10.ex_342;

//static import java.lang.System.out;
import java.util.*;
/**
 * @autor irinaff
 * @since 30.01.2017
 **/

public class FoolMoons {
    static int DAY_IM = 1000 * 60 * 60 * 24;

    public static void main (String [] args) {

        Calendar c = Calendar.getInstance();
        c.set(2004,1,7,15,40);
        long day1 = c.getTimeInMillis();

        for (int x = 0; x < 60; x++) {
            day1 += (DAY_IM * 29.52);
            //обновляем время
            c.setTimeInMillis(day1);
            System.out.println(String.format("полнолуние было в %tc",c));
        }


    }
}
