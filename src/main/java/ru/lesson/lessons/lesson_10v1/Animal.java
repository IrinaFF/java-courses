package ru.lesson.lessons.lesson_10v1;


/**
 * Базовый класс для животных
 *
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Animal implements Pet {
    private String name;//Имя
    //private Pet pet;

    //Конструктор
    //@param name Имя животного
    public Animal(final String name) {
        this.name = name;
    }

//    public Animal(final Pet pet) {
//        this.pet = pet;
//        this.name = pet.getName();
//    }

    public String getName() {
        return this.name;
    }

    //Сменить имя питомца
    public void changeName(String name) {
        this.name = name;
    }

    //Подать голос
    public void makeSound() {
        System.out.println(
                String.format("%s say: %s", this.name, "beep"));
    }
}
