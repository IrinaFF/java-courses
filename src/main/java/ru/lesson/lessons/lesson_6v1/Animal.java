package ru.lesson.lessons.lesson_6v1;

/**
 * Базовый класс для животных
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Animal implements Pet {
    private String name;//Имя
    private Pet pet;

    //Конструктор
    //@param name Имя животного
    public Animal(final String name){
        this.name = name;
    }

    public Animal(final Pet pet){
        this.pet = pet;
        this.name = pet.getName();
    }

    //Подать голос
    public void makeSound(){
        this.makeSound();
        System.out.println(
                String.format("%s say: %s", this.name, "beep")
        );
    };
    public  String getName(){
        return this.name;
    };

    //Сменить имя питомца
    public void changeName(String name) {
        this.name = name;
    };
}
