package syerraBeyts.glava_10.ex_318;

import java.util.ArrayList;

/**
 * без автоматического упаковвывания (версии Java до 5.0)
 * @autor irinaff
 * @since 28.01.2017
 **/

public class doNumsOldWay {
    public static void main (String [] args) {
        ArrayList listOfNumbers = new ArrayList();
        listOfNumbers.add(new Integer(3));
        Integer one = (Integer) listOfNumbers.get(0);
        int intOne = one.intValue();
        System.out.println("intOne= " + intOne);
    }
}
