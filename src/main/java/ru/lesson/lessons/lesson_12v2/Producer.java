package ru.lesson.lessons.lesson_12v2;

import ru.lesson.lessons.UserArray.User;
import java.util.List;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 20.02.2017
 **/

public class Producer extends Thread {
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
