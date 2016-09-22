package Clinica;

/**
 * Базовый класс для животных
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Animal implements Pet {

    /**
     * Имя
     */
    public String name;

    /**
     * Конструктор
     * @param name Имя животного
     */

    public Animal(final String name){
        this.name = name;
    }

    /**
     * Подать голос
     */
    @Override
    public void makeSound(){
        this.makeSound();
        System.out.println(
                String.format("%s say: %s", this.name, "beep")
        );
    };
    @Override
    public  String getName(){
        return this.getName();
    };
}
