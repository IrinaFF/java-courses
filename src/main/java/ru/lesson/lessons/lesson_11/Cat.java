package ru.lesson.lessons.lesson_11;

/**
 * Реализация кота. Он умеет мяукать и ловить мышей
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Cat implements Pet {
    public String name;

    /**
     * Конструктор
     * @param name Имя животного
     **/
    public Cat(String name) {
        this.name = name;
        //System.out.println("Cat: " + this.name);
    };

    /**
     * Поймать мышь
     **/
    public void catchMouth() {
    }

    /**
     * Подать голос
     */
    //@Override
    public void makeSound(){
        System.out.println(
                String.format("%s say: %s", this.name, "Mau, Mau")
        );
    };
    /**
     * Получить имя питомца
     **/
    //@Override
    public  String getName(){
        return this.name;
    };

    /**
     * Сменить имя питомца
     * */
    //@Override
    public void changeName(String name) {
        this.name = name;
        System.out.println("Cat changeName: " + name);
    };

}
