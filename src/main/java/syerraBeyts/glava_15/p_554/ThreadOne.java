package syerraBeyts.glava_15.p_554;

/**
 * задача 1
 * @autor irinaff
 * @since 03.02.2017
 **/

public class ThreadOne implements Runnable {
    Accum a = Accum.getAccum();

    public void run() {

        for (int i = 0; i < 98; i++) {
            //a.updateCounter(1);
            a.updateCounter(1000);
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

        //a.updateCounter(1000);
        System.out.println("один " + a.getCount());
    }
}
