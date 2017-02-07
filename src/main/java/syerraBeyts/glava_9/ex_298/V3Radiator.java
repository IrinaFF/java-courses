package syerraBeyts.glava_9.ex_298;

import java.util.ArrayList;

/**
 * Необходимо, чтобы юниты v3 и v2,
 * принадлежащие радиаторным машинам, работали в пропорции 2:1.
 * @autor irinaff
 * @since 28.01.2017
 **/

class V3Radiator {//extends V2Radiator {
    V3Radiator(ArrayList lglist) {
        //super(lglist);
        for (int g=0; g<10; g++) {
            lglist.add(new SimUnit("V3Radiator"));
            System.out.println(g + " create V3Radiator");
        }
    }
}
