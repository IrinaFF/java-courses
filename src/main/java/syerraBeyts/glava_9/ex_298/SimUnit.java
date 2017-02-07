package syerraBeyts.glava_9.ex_298;

/**
 * симуляция
 * @autor irinaff
 * @since 28.01.2017
 **/

class SimUnit {
    String botType;
    int power;

    SimUnit(String type) {
        botType = type;
        power = powerUse();
    }
    int powerUse() {
        if ("Тепловая машина".equals(botType)) {
            return 2;
        } else {
            return 4;
        }
    }
}
