package ru.lesson.lessons.lesson_12;

import org.junit.Test;
import ru.lesson.lessons.lesson_10.User;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 25.10.2016
 **/

public class BlockQueueTest {
    @Test
    public void queue() throws InterruptedException {

        final BlockQueue<User> queue = new BlockQueue<User>();
        final List<Customer> customers = Arrays.asList(new Customer(queue), new Customer(queue));
        //System.out.printf("customers %s : %s %n", Thread.currentThread().getId(), customers.size());

        for (Customer customer : customers) {
            customer.start();
        }
        Producer producer = new Producer(
                queue,
                Arrays.asList(
                        new User("1", "1"), new User("2", "2"),
                        new User("3", "3"), new User("4", "4")
                )
        );
        producer.start();
        //говорим дочернему треду чтобы он джойнился
        producer.join();
        Thread.sleep(101);
        int count = 0;
        for (Customer customer : customers) {
            count += customer.size();
        }
        //assertEquals(count, producer.size());
    }

    private static final class Producer extends Thread {
        private final BlockQueue<User> queue;
        private final List<User> store;

        public Producer(final BlockQueue<User> queue, final List<User> store) {
            super();
            System.out.printf("Producer %s : %s %n", Thread.currentThread().getId(), "start");
            this.queue = queue;
            this.store = store;
        }

        @Override
        public void run() {
            for (User user : this.store) {
                this.queue.push(user);
                System.out.printf("Producer %s : %s %n", Thread.currentThread().getId(), user);
            }
        }

        public int size() {return this.store.size();}
    }

    private static final class Customer extends Thread {
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

}