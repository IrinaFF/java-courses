package Clinica;

/**
 * Реализация животного
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Animal implements Pet {
    public String name;

    public Animal(final String name){
        this.name = name;
    }

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
