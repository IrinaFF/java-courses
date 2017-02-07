package syerraBeyts.glava_15.p_524;

/**
 * задача потока
 * @autor irinaff
 * @since 03.02.2017
 **/

public class MyRunnable implements Runnable {
    public void run() {
        go();
    }

    public void go() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        doMore();
    }

    public void doMore() {
        System.out.println("doMore, Вершина стека");
    }
}
