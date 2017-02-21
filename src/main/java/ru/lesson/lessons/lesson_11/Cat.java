package ru.lesson.lessons.lesson_11;

/**
 * Реализация кота. Он умеет мяукать и ловить мышей
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Cat extends Animal implements Pet {
    private String name;
    private Pet pet;

    //Конструктор
    //@param name Имя животного
    public Cat (String name) {
        super(name);
        this.name = name;
        //System.out.println("Cat: " + this.name);
    };

    //Подать голос
    @Override
    public void makeSound(){
        System.out.println(
                String.format("%s say: %s", this.name, "Mau, Mau")
        );
    };

    //Получить имя питомца
    //public  String getName(){ return this.name;    };

    //Сменить имя питомца
    /*
    public void changeName(String name) {
        this.name = name;
        System.out.println("Cat changeName: " + name);
    };
    */

    //Поймать мышь
    public void catchMouth() {
    }
}
