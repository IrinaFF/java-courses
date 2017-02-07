package syerraBeyts.glava_9.ex_298;

import java.util.ArrayList;

/**
 * В целом соотношение систем, удерживающих тепло, к радиаторным
 * машинам должно составлять 4:3
 * @autor irinaff
 * @since 28.01.2017
 **/

class RetentionBot {
    RetentionBot (ArrayList rlist) {
        rlist.add(new SimUnit("Тепловая машина"));
        System.out.println("create RetentionBot");
    }
}
