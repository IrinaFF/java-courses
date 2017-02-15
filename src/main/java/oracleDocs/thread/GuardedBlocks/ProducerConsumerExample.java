package oracleDocs.thread.GuardedBlocks;

/**
 * Created by Irina on 16.02.2017.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
