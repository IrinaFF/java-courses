package syerraBeyts.glava_9.ex_298;

import java.util.ArrayList;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 28.01.2017
 **/

public class TestLifeSupportSim {
    public static void main (String [] args) {
        ArrayList aList = new ArrayList();
        V2Radiator v2 = new V2Radiator(aList);
        V3Radiator v3 = new V3Radiator(aList);
        for (int z=0; z<20; z++) {
            RetentionBot ret = new RetentionBot(aList);
        }
        int allPower = 0;
        for (int z=0; z < aList.size(); z++) {
            SimUnit s = (SimUnit) aList.get(z);
            //System.out.println(z + " > "  + s.botType + " > " + s.power);
            allPower += s.power;
        }
        System.out.println("allPower= " + allPower);
    }
}
