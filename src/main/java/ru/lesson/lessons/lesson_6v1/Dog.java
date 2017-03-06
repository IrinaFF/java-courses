package ru.lesson.lessons.lesson_6v1;

/**
 * Реализация собаки
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Dog extends Animal implements Pet {
    private String name;
    private Pet pet; //переменная для ссылки на объект реализующий интерфейс

    //Конструктор
    //@param name Имя животного
    public Dog(final String name){
        super(name);
        this.name = name;
    }

    //Конструктор
    //@param pet ссылка на объект
    public Dog(final Pet pet) {
        super(pet);
        this.pet = pet;
        this.name = pet.getName();
    };

    //Подать голос
    @Override
    public void makeSound(){
        this.pet.makeSound();
        System.out.println(
                String.format("%s say: %s", this.name, "Gav, Gav")
        );
    };

    //public  String getName(){ return this.name; };

    //Сменить имя питомца
    /*
    public void changeName(String name) {
        this.name = name;
        System.out.println("Dog changeName: " + name);
    };
    */
}
