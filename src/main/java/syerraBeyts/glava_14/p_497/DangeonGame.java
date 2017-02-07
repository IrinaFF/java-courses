package syerraBeyts.glava_14.p_497;

import java.io.*;
/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 02.02.2017
 **/

public class DangeonGame implements Serializable {
    public int x = 3;
    transient long y = 4;
    private short z = 5;

    int getX() {
        return x;
    }

    long getY() {
        return y;
    }

    short getZ() {
        return z;
    }
}
