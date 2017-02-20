package ru.lesson.lessons.lesson_12v2;

import ru.lesson.lessons.UserArray.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 20.02.2017
 **/

public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {

        //public void queue() throws InterruptedException {
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
            //чтобы главный поток подождал завершения побочного потока
            System.out.println("собираемся сказать чтобы главный поток подождал завершения побочного потока");
            producer.join();
            System.out.println("ранее сказали чтобы главный поток подождал завершения побочного потока");
            Thread.sleep(101);
            System.out.println("закончилось sleep(101)");
            int count = 0;
            for (Customer customer : customers) {
                count += customer.size();
            }
            //assertEquals(count, producer.size());
            if (count == producer.size()) {
                System.out.println("==");
            } else {
                System.out.println("!=");
            }
        }

    //}
}
