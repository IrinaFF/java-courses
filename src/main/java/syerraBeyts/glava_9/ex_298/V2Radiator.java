package syerraBeyts.glava_9.ex_298;
import java.util.*;
/**
 * Необходимо, чтобы юниты v3 и v2,
 * принадлежащие радиаторным машинам, работали в пропорции 2:1.
 * @autor irinaff
 * @since 28.01.2017
 **/

public class V2Radiator {
    V2Radiator(ArrayList list) {
        for (int x=0; x<5; x++) {
            list.add(new SimUnit("V2Radiator"));
            System.out.println(x + " create V2Radiator");
        }
    }
}
