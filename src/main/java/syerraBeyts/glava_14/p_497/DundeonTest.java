package syerraBeyts.glava_14.p_497;

import java.io.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 02.02.2017
 **/

public class DundeonTest  {

    public static void main(String [] args) {
        DangeonGame d = new DangeonGame();
        System.out.println(d.getX() + d.getY() + d.getZ());

        try {
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DangeonGame) ois.readObject();
            ois.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(d.getX() + d.getY() + d.getZ());
        System.out.println("getX=" + d.getX() +" getY="+ d.getY() + " getZ=" + d.getZ());
    }
}
