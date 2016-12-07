package ru.lesson.lessons.lesson_12;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 22.10.2016
 **/

public class CounterTest {
    @Test
    public void increase() throws InterruptedException {
        final Counter counter = new Counter();
        final List<Reader> readers = Arrays.asList(
                new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter),
                new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter)
        );
        for (final Reader reader : readers) {
            reader.start();
        }
        Thread.sleep(10001);
        assertEquals(1201,counter.increase());
    }

    private static final class Reader extends Thread {
        private final Counter counter1;

        public Reader(Counter counter) {
            this.counter1 = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i != 100; ++i) {
                System.out.println(String.format("%s : %s", Thread.currentThread().getId(), this.counter1.increase()));
                //System.out.println(String.format("%s : %s", Thread.currentThread().getId(), this.counter.getAmount()));
            }
        }
    }

}