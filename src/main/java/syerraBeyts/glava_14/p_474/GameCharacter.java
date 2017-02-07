package syerraBeyts.glava_14.p_474;

import java.io.*;
/**
 * класс для теста сериализации
 * @autor irinaff
 * @since 01.02.2017
 **/

public class GameCharacter implements java.io.Serializable {
    int power;
    String type;
    String [] weapons;

    public GameCharacter (int p, String t, String [] w) {
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponsList = "";
        for (int i = 0; i < weapons.length; i++) {
            weaponsList += weapons[i] + " ";
        }
        return weaponsList;
    }
}
