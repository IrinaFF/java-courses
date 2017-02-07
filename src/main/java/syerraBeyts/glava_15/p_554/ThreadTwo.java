package syerraBeyts.glava_15.p_554;

/**
 * задача 2
 * @autor irinaff
 * @since 03.02.2017
 **/

public class ThreadTwo implements Runnable {
    Accum a = Accum.getAccum();

    public void run() {

        for (int i = 0; i < 99; i++) {
            a.updateCounter(1);
            //a.updateCounter(1000);
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        //a.updateCounter(1);
        System.out.println("два " + a.getCount());
    }
}
