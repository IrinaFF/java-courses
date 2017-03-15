package ru.lesson.lessons.lesson_10v1;


/**
 * Реализация кота. Он умеет мяукать и ловить мышей
 *
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Cat extends Animal {
    private String name;
    //private Pet pet;

    //Конструктор
    public Cat(String name) {
        super(name);
        this.name = name;
    }

    //Подать голос
    @Override
    public void makeSound() {
        System.out.println(
                String.format("%s say: %s", this.name, "Mau, Mau")
        );
    }
}
