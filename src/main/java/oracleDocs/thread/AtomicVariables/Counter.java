package oracleDocs.thread.AtomicVariables;

/**
 * Created by Irina on 19.02.2017.
 */
class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}
