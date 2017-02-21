package ru.lesson.lessons.lesson_11;

/**
 * Реализация котопса
 * @autor irinaff
 * @since 17.09.2016
 **/

public class CatDog implements Pet {
    private Cat cat; //переменная для ссылки на объект реализующий интерфейс
    private Dog dog; //переменная для ссылки на объект реализующий интерфейс

    public CatDog(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    };

     public void makeSound(){
        this.cat.makeSound();
        this.dog.makeSound();
    };
    public  String getName(){
        return String.format("%s + %s",
                this.cat.getName(), this.dog.getName());
    };

    public void changeName(String name) {
        this.cat.changeName(name);
        this.dog.changeName(name);
    };

    //Сменить имя питомца
    public void changeName(String nameCat, String nameDog) {
    this.cat.changeName(nameCat);
    this.dog.changeName(nameDog);
    };
}
