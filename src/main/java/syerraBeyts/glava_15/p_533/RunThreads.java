package syerraBeyts.glava_15.p_533;


/**
 * создание и запуск двух потоков
 * @autor irinaff
 * @since 03.02.2017
 **/

public class RunThreads implements Runnable {

    public static void main(String [] args) {
        //создаем один экземпляр Runnable - одно задание
        RunThreads runner = new RunThreads();
        //создаем два потока с одним задание
        Thread alpha = new Thread(runner);
        Thread beta = new Thread(runner);
        //имена потоков
        alpha.setName("alpha");
        beta.setName("beta");
        //запускаем потоки
        alpha.start();
        beta.start();
    }

    public void run() {

        //каждый поток пройдя через этот цикл выведет имя в каждой итерации
        for (int i = 0; i < 25; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println( i + " -> " + threadName);
        }
    }
}
