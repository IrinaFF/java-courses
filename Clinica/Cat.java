package Clinica;

/**
 * Реализация кошки
 * @autor irinaff
 * @since 17.09.2016
 **/

public class Cat implements Pet {
    public final String name;

    //Cat() {};
    Cat(String name) {
        this.name = name;
    };

    public void makeSound(){
        System.out.println("Mau, Mau");
    };

    public  String getName(){
        return this.name;
    };
}
