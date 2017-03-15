package ru.lesson.lessons.lesson_10v1;


/**
 * Клиент
 */
public class Person {
    private String name;

    /**
     * Конструктор
     * @param name Имя
     */
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
