package ru.lesson.lessons.lesson_10v1;

/**
 * Реализация собаки
 *
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Dog extends Animal {
    private String name;
    //private Pet pet; //переменная для ссылки на объект реализующий интерфейс

    //Конструктор
    //@param name Имя животного
    public Dog(final String name) {
        super(name);
        this.name = name;
    }

    //Подать голос
    @Override
    public void makeSound() {
        System.out.println(
                String.format("%s say: %s", this.name, "Gav, Gav"));
    }

}
