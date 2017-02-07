package syerraBeyts.glava_15.p_524;

/**
 * тестирование запуска потока
 * @autor irinaff
 * @since 03.02.2017
 **/

public class ThreadTester {

    public static void main(String [] args) {
        Runnable threadJob = new MyRunnable();
        Thread myTjread = new Thread(threadJob);

        myTjread.start();
        System.out.println("Возвращаемся в метод main");
    }
}
