package oracleDocs.thread.AtomicVariables;

/**
 * Created by Irina on 19.02.2017.
 */
class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }

}

