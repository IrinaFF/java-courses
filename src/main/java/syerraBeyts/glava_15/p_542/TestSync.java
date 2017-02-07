package syerraBeyts.glava_15.p_542;

/**
 * проблема последнего изменения
 * @autor irinaff
 * @since 03.02.2017
 **/

public class TestSync implements Runnable {
    private int balance;

    public void run() {
        //поток зацикливается и в каждой итерации пытается снять деньги со счета
        //после снятия он еще раз проверяет баланс
        for (int i = 0; i < 10; i++) {
            increment();
            System.out.println(
                    //Thread.currentThread().getName() + " (" +
                    i + ") баланс равен " + balance);
        }
    }

    public synchronized void increment() {
        int i = balance;
        balance = i + 1;
    }
}
