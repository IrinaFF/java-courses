package syerraBeyts.glava_14.p_467;

import java.io.*;
/**
 * сериализация
 * @autor irinaff
 * @since 01.02.2017
 **/

public class Box implements Serializable {

    private int wigth;
    private int heigth;

    public void setWigth(int w) {
        wigth = w;
    }
    public void setHeigth(int h) {
        heigth = h;
    }

    public static void main(String [] args) {
        Box myBox = new Box();
        myBox.setWigth(50);
        myBox.setHeigth(20);

        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
