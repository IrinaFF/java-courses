package Clinica;

/**
 * Реализация кошки
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Cat extends Pet {
    public final String name;


    public Cat(String name) {
        this.name = name;
    };

    public void makeSound(){
        System.out.println("Mau, Mau");
    };

    public  String getName(){
        return this.name;
    };
}
