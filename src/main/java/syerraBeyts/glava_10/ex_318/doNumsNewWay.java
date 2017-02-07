package syerraBeyts.glava_10.ex_318;

import java.util.ArrayList;

/**
 * с автоматической упаковкой (версии Java 5.0 и выше)
 * @autor irinaff
 * @since 28.01.2017
 **/

public class doNumsNewWay {
    public static void main (String [] args) {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(3);
        int num = listOfNumbers.get(0);
        System.out.println("num= " + num);

        //я экспериментировала
        ArrayList list1 = new ArrayList();
        list1.add(1);
        int intOne1 = (Integer) list1.get(0);
        System.out.println("intOne1= " + intOne1);
    }
}
