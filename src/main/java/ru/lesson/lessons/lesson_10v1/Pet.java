package ru.lesson.lessons.lesson_10v1;

/** Описывает поведение питомца
 * @autor irinaff
 * @since 17.09.2016
 **/

public interface Pet {

    //Издавать звук
    public void makeSound();

    //Получить имя питомца
    String getName();

    //Сменить имя питомца
    public void changeName(String name);
}

