package ru.lesson.lessons.lesson_12v2;

import ru.lesson.lessons.UserArray.User;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 20.02.2017
 **/

public class Customer extends Thread {
    private final BlockQueue<User> queue;
    private final AtomicInteger counter = new AtomicInteger(0);

    public Customer(final BlockQueue<User> queue) {
        super();
        System.out.printf("Customer %s : %s %n", Thread.currentThread().getId(), "start");
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(
                    String.format("Customer %s : %s", Thread.currentThread().getId(), this.queue.poll())
            );
            counter.incrementAndGet();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int size() {return this.counter.get();}
}
