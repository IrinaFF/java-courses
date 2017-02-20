package ru.lesson.lessons.lesson_12v2;

/**
 * TODO: comment
 *
 * @autor irinaff
 * @since 22.10.2016
 **/

public class Counter {
    private int amount;

    //public int increase () {
    public synchronized int increase () {
        amount++;
        return amount;
    }

    public int getAmount() {
        return amount;
    }

    //так не стоит делать, т.к. лочится весь класс
    public static synchronized void echo () {}
}
